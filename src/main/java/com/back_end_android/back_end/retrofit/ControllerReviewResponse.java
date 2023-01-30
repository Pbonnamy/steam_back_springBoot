package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Language;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ControllerReviewResponse {

    public List<ReviewResponse.Review> start(int id, Language language) throws IOException {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://store.steampowered.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request request = chain.request();
                                request = request.newBuilder()
                                        .header("Cache-Control", "public, max-age=" + 3600)
                                        .build();
                                return chain.proceed(request);
                            }
                        })
                        .build())
                .build();
        SteamApi reviewApi = retrofit.create(SteamApi.class);
        Call<ReviewResponse> call = reviewApi.getReviews(id, 1, language.getLanguage());
        Response<ReviewResponse> reviewResponseResponse = call.execute();
        if(reviewResponseResponse.isSuccessful()){
            ReviewResponse reviewResponse = reviewResponseResponse.body();
            return reviewResponse.reviews;
        }
        return null;


    }

}
