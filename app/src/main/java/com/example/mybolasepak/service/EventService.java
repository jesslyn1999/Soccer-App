package com.example.mybolasepak.service;

import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.model.EventList;

import retrofit2.Call;


public class EventService {
    public static String getData() {
        RetrofitServiceInterface retrofitServiceInterface = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<EventList> call = retrofitServiceInterface.doGetEvent();
        try {
            System.out.println(call.execute().body().getEvents().get(0));
            System.out.println("SUCCESS");
        } catch (Exception exc) {
            System.out.println("ERROR");
        }
        return "WTH";
    }
}
