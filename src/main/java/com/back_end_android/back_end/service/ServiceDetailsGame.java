package com.back_end_android.back_end.service;

import com.back_end_android.back_end.models.Language;
import com.back_end_android.back_end.models.User;
import com.back_end_android.back_end.models.WhishList;
import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.models.responseRetrofit.ReviewEntityReponse;
import com.back_end_android.back_end.models.responseRetrofit.SearchItem;
import com.back_end_android.back_end.repository.UserRepository;
import com.back_end_android.back_end.repository.WishlistRepository;
import com.back_end_android.back_end.retrofit.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceDetailsGame {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishlistRepository wishlistRepository;

    public GameDetails setGame(int id, String country) throws IOException {
        ControllerOther controller = new ControllerOther();
        return controller.start(id, country);
    }

    public ReviewEntityReponse setReview(ReviewResponse.Review review) throws IOException {
        ReviewEntityReponse reviewEntityReponse = new ReviewEntityReponse();
        reviewEntityReponse.setId(review.getAuthor().getSteamid());
        reviewEntityReponse.setDescription(review.getReview());
        double score = Double.valueOf(review.getWeightedVoteScore()) * 5;
        reviewEntityReponse.setLike((int) score);
        reviewEntityReponse.setName(getNameofPlayerWithSteamId(reviewEntityReponse.getId()));
        return reviewEntityReponse;

    }


    private String getNameofPlayerWithSteamId(String id) throws IOException {
        String page = getContent(id);
        String[] name = extractTitle(page).split(" :: ");
        return name[1];
    }

    private String getContent(String id) throws IOException {
        final OkHttpClient client = new OkHttpClient.Builder().build();
        final String urlToScrape = "https://steamcommunity.com/profiles/"+id;// + id;
        final Request request = new Request.Builder().url(urlToScrape).build();
        final Response response = client.newCall(request).execute();
        return response.body().string();
    }


    private String extractTitle(String content) {
        final Pattern titleRegExp = Pattern.compile("<title>(.*?)</title>", Pattern.DOTALL);
        final Matcher matcher = titleRegExp.matcher(content);
        matcher.find();
        return matcher.group(1);
    }


    public List<GameDetails> listRanking(String country, int start,int finish ) throws IOException {
        ControllerTest controllerTest = new ControllerTest();
        int[] ids = controllerTest.start();
        List<GameDetails> gameDetailsList = new ArrayList<>();
        int max = Math.min(finish, ids.length);
        for (int i= start; i<max; i++){
            gameDetailsList.add(setGame(ids[i], country));
        }
        return gameDetailsList;
    }


    public List<ReviewEntityReponse> listReviewGame(String countryCode, int id, int start, int finish) throws IOException {
        Language language = Language.valueOf(countryCode.toUpperCase());
        ControllerReviewResponse controller = new ControllerReviewResponse();
        List<ReviewResponse.Review> reviews = controller.start(id, language);
        int max = Math.min(finish, reviews.size());
        List<ReviewEntityReponse> reviewResponseList = new ArrayList<>();
        for (int i=start; i<max; i++){
            reviewResponseList.add(setReview(reviews.get(i)));
        }

        return reviewResponseList;

    }


    public List<GameDetails> listSearch(String search, String countryCode) throws IOException {
        ControllerSearch controllerSearch = new ControllerSearch();
        SearchRetrofit searchRetrofit = controllerSearch.start(search);
        List<SearchRetrofit.Item> items = searchRetrofit.getItems();
        List<GameDetails> searchItems = new ArrayList<>();
        for (int i=0; i<items.size(); i++){
            int id = items.get(i).getId();
            searchItems.add(setGame(id, countryCode));
        }
        return searchItems;
    }


    public WhishList save(String name,String countryCode,  int steamId, String type) throws IOException {
        Optional<User> user =  userRepository.findByUsername(name);
        if(!user.isPresent()) {
            return null;
        }
        String userId = user.get().getId();
        GameDetails gameDetails = setGame(steamId, countryCode);
        WhishList whishList = new WhishList(userId,gameDetails.getName(), gameDetails.getId(),gameDetails.getEditor(),gameDetails.getUrlImage(),
                gameDetails.getCover(),gameDetails.getDescription(),gameDetails.getPrice(), countryCode,  type);
        return wishlistRepository.save(whishList);

    }


    public void delete(String id){
        wishlistRepository.deleteById(id);
    }


    public List<WhishList> listWhishlist(String name, String type){
        Optional<User> user =  userRepository.findByUsername(name);
        if(!user.isPresent()) {
            return null;
        }
        String userId = user.get().getId();
        return wishlistRepository.findAllByTenantAndType(userId, type);
    }

}
