package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;


public class ControllerOther  {



    public GameDetails start(int id, String countryCode) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://store.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SteamApi steamApi = retrofit.create(SteamApi.class);
        Call<Map<String, SteamApp>> call = steamApi.getAppDetails(String.valueOf(id), countryCode);
        Response<Map<String, SteamApp>> test = call.execute();
        if (test.isSuccessful()) {
            Map<String, SteamApp> appDetails = test.body();
            return createGameDetails(appDetails.get(String.valueOf(id)));

        }
        return null;
    }

    private GameDetails createGameDetails(SteamApp steamApp){
        GameDetails gameDetails = new GameDetails();
        SteamApp.Data data = steamApp.getData();
        gameDetails.setName(data.getName());
        gameDetails.setDescription(data.getDetailed_description());
        gameDetails.setEditor(data.getPublishers().get(0));
        System.out.println(steamApp.getData());
        String[] cover = data.getHeader().split("\\?t");
        String[] image = data.getScreenshots().get(0).getPath_full().split("\\?t");
        gameDetails.setUrlImage(image[0]);
        gameDetails.setCover(cover[0]);
        return  gameDetails;
    }








}
