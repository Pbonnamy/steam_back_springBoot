package com.back_end_android.back_end.retrofit;

import com.back_end_android.back_end.models.Pojo;
import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.service.ServiceDetailsGame;
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


public class ControllerTest  {

    static final String BASE_URL = "https://api.steampowered.com/";

    public int[] start() throws IOException {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
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

        SteamApi gerritAPI = retrofit.create(SteamApi.class);

        Call<Pojo> call = gerritAPI.loadListCharts();
        Response<Pojo> pojo =  call.execute();
        if (pojo.isSuccessful()){
            Pojo pojo1 = pojo.body();
            List<Pojo.Rank> ranks=  pojo1.getResponse().getRanks();
            return ranks.stream()
                    .mapToInt(it-> it.getAppId())
                    .toArray();
        }
        return null;
    }
}
