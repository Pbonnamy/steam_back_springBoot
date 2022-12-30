package com.back_end_android.back_end.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ControllerReviewResponse {

    public List<ReviewResponse.Review> start(int id) throws IOException {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://store.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SteamApi reviewApi = retrofit.create(SteamApi.class);
        Call<ReviewResponse> call = reviewApi.getReviews(id, 1);
        Response<ReviewResponse> reviewResponseResponse = call.execute();
        if(reviewResponseResponse.isSuccessful()){
            ReviewResponse reviewResponse = reviewResponseResponse.body();
            return reviewResponse.reviews;
        }
        return null;


    }

}
