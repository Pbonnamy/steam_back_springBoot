package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Pojo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Map;

public interface SteamApi {
    @GET("ISteamChartsService/GetMostPlayedGames/v1/")
    Call<Pojo> loadListCharts();

    @GET("api/appdetails")
    Call<Map<String, SteamApp>> getAppDetails(@Query("l") String l, @Query("appids") String appids, @Query("cc") String cc);

    @GET("appreviews/{id}")
    Call<ReviewResponse> getReviews(@Path("id") int id, @Query("json") int json, @Query("language") String language);

    @GET("storesearch/")
    Call<SearchRetrofit> getSearch(@Query("term") String search, @Query("l") String country, @Query("cc") String countryCode);
}
