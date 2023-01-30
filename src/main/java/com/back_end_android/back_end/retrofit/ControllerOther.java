package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Language;
import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ControllerOther {


    public GameDetails start(int id, String countryCode) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://store.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SteamApi steamApi = retrofit.create(SteamApi.class);
        Language language = Language.valueOf(countryCode.toUpperCase());
        Call<Map<String, SteamApp>> call = steamApi.getAppDetails(language.getLanguage(), String.valueOf(id), countryCode);
        Response<Map<String, SteamApp>> test = call.execute();
        if (test.isSuccessful()) {
            Map<String, SteamApp> appDetails = test.body();
            return createGameDetails(appDetails.get(String.valueOf(id)), id, language);

        }
        return null;
    }

    private GameDetails createGameDetails(SteamApp steamApp, int id, Language language) {
        GameDetails gameDetails = new GameDetails();

        SteamApp.Data data = steamApp.getData();
        gameDetails.setName(data.getName());
        gameDetails.setSteamId(id);
        String noImages = data.getDetailed_description().replaceAll("<img[^>]*>", "");
        gameDetails.setDescription(noImages);
        gameDetails.setEditor(data.getPublishers().get(0));
        String[] cover = data.getHeader().split("\\?t");
        if (data.getPriceOverview() == null) {
            gameDetails.setPrice(language.getPrice());
        } else {
            gameDetails.setPrice(data.getPriceOverview().getFinalFormatted());
        }
        List<String> images = new ArrayList<>();
        images.add(data.getScreenshots().get(0).getPath_full().split("\\?t")[0]);
        images.add(data.getScreenshots().get(1).getPath_full().split("\\?t")[0]);
        gameDetails.setUrlImage(images);
        gameDetails.setCover(cover[0]);
        return gameDetails;
    }


}
