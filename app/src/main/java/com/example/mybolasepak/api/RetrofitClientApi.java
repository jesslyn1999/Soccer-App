package com.example.mybolasepak.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApi {
    private static final String TAG = "RetrofitClientApi";

    private static final String SPORTDB_API_BASE_URL = "https://www.thesportsdb.com/api/";
    private static final String OPENWEATHER_API_BASE_URL = "http://api.openweathermap.org/";
    private static final String OPENWEATHER_BASE_URL = "http://openweathermap.org/";

    private static final String OPENWEATHER_APP_ID = "0dbb99a65ac022097cb23364f56745f1";
    private static final String OPENWEATHER_LANG = "id";

    private static Gson gson;

    public static Retrofit getSportDbInstance() {
        Log.i(TAG, "Ready to getInstance of SportDb retrofit");

        gson = new GsonBuilder().create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        return new Retrofit.Builder()
                .baseUrl(SPORTDB_API_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    public static Retrofit getApiOpenWeatherInstance() {
        Log.i(TAG, "Ready to getInstance of ApiOpenWeather retrofit");
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(@NonNull Chain chain) throws IOException {
                                        Log.i(TAG, "WHERE R U NOW");
                                        Request original = chain.request();
                                        HttpUrl url = original.url().newBuilder()
                                                .addQueryParameter("appid", OPENWEATHER_APP_ID)
                                                .addQueryParameter("lang", OPENWEATHER_LANG)
                                                .build();
                                        Request request = original.newBuilder()
                                                .url(url)
                                                .build();
                                        Log.i(TAG, "HEYY it's : " + request.header("appid"));
                                        return chain.proceed(request);
                                    }
                                }
                )
                .build();

        Gson gson = new GsonBuilder().create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        return new Retrofit.Builder()
                .baseUrl(OPENWEATHER_API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    public static Retrofit getOpenWeatherInstance() {
        Log.i(TAG, "Ready to getInstance of OpenWeather retrofit");
        Gson gson = new GsonBuilder().create();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
        return new Retrofit.Builder()
                .baseUrl(OPENWEATHER_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

}
