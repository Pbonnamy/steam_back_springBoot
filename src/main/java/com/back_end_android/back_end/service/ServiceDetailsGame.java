package com.back_end_android.back_end.service;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.models.responseRetrofit.ReviewEntityReponse;
import com.back_end_android.back_end.models.responseRetrofit.SearchItem;
import com.back_end_android.back_end.retrofit.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDetailsGame {

    public GameDetails setGame(int id, String country) throws IOException {
        ControllerOther controller = new ControllerOther();
        return controller.start(id, country);
    }

    public GameDetails setGame(int id) throws IOException {
        ControllerOther controller = new ControllerOther();
        return controller.start(id, "fr");
    }

    public ReviewEntityReponse setReview(ReviewResponse.Review review){
        ReviewEntityReponse reviewEntityReponse = new ReviewEntityReponse();
        reviewEntityReponse.setId(review.getAuthor().getSteamid());
        reviewEntityReponse.setDescription(review.getReview());
        reviewEntityReponse.setLike(review.isVotedUp());
        return reviewEntityReponse;

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


    public List<ReviewEntityReponse> listReviewGame(int id, int start, int finish) throws IOException {
        ControllerReviewResponse controller = new ControllerReviewResponse();
        List<ReviewResponse.Review> reviews = controller.start(id);
        int max = Math.min(finish, reviews.size());
        List<ReviewEntityReponse> reviewResponseList = new ArrayList<>();
        for (int i=start; i<max; i++){
            reviewResponseList.add(setReview(reviews.get(i)));
        }

        return reviewResponseList;

    }


    public List<GameDetails> listSearch(String search) throws IOException {
        ControllerSearch controllerSearch = new ControllerSearch();
        SearchRetrofit searchRetrofit = controllerSearch.start(search);
        List<SearchRetrofit.Item> items = searchRetrofit.getItems();
        List<GameDetails> searchItems = new ArrayList<>();
        for (int i=0; i<items.size(); i++){
            int id = items.get(i).getId();
            searchItems.add(setGame(id));
        }
        return searchItems;
    }

}
