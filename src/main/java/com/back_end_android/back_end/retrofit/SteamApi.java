package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Game;
import com.back_end_android.back_end.models.Pojo;
import com.back_end_android.back_end.models.responseRetrofit.Price;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

import java.util.Map;

public interface SteamApi {
    @GET("ISteamChartsService/GetMostPlayedGames/v1/")
    Call<Pojo> loadListCharts();

    @GET("api/appdetails")
    Call<Map<String, SteamApp>> getAppDetails(@Query("appids") String appids, @Query("cc") String cc);
    @GET("api/appdetails")
    Call<Price> getAppDetails(@Query("appids") String appids, @Query("cc") String cc, @Query("filters")  String price_overview);

    @GET("appreviews/{id}")
    Call<ReviewResponse> getReviews(@Path("id") int id, @Query("json") int json);

    @GET("storesearch/")
    Call<SearchRetrofit> getSearch(@Query("term") String search,@Query("l") String country, @Query("cc") String countryCode);
}
