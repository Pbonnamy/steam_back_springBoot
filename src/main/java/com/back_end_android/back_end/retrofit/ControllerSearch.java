package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Language;
import com.back_end_android.back_end.models.Pojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ControllerSearch {

    public SearchRetrofit start(String br, String countryCode) throws IOException {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://store.steampowered.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Chain chain) throws IOException {
                                Request request = chain.request();
                                request = request.newBuilder()
                                        .header("Cache-Control", "public, max-age=" + 60)
                                        .build();
                                return chain.proceed(request);
                            }
                        })
                        .build()
                )
                .build();


        SteamApi steamApi = retrofit.create(SteamApi.class);
        Language language = Language.valueOf(countryCode.toUpperCase());
        Call<SearchRetrofit> searchRetrofitCall = steamApi.getSearch(br,language.getLanguage(), countryCode);
        Response<SearchRetrofit> searchRetrofitResponse = searchRetrofitCall.execute();
        if (searchRetrofitResponse.isSuccessful()){
            return searchRetrofitResponse.body();
        }
        return null;
    }
}
