package com.example.mybolasepak.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApi {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/";
    private static final String TAG = "RetrofitClientApi";

    private static Gson gson;

    public static Retrofit getInstance() {
        Log.i(TAG, "Ready to getInstance");

        gson = new GsonBuilder().create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

}
