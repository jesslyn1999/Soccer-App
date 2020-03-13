package com.example.mybolasepak.api;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApi {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/";

    public static Retrofit getInstance() {
        Log.i("HMM", "CHINGSIM");
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

}
