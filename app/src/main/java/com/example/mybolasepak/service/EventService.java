package com.example.mybolasepak.service;

import com.example.mybolasepak.api.RetrofitApiInterface;
import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.model.ListEvent;

import retrofit2.Call;


public class EventService {
    public static String getData() {
        RetrofitApiInterface retrofitApiInterface = RetrofitClientApi.getClient().create(RetrofitApiInterface.class);
        Call<ListEvent> call = retrofitApiInterface.doGetEvent();
        try {
            System.out.println(call.execute().body().getEvents().get(0));
            System.out.println("SUCCESS");
        } catch (Exception exc) {
            System.out.println("ERROR");
        }
        return "WTH";
    }
}
