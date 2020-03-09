package com.example.mybolasepak.api;

import com.example.mybolasepak.model.EventList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServiceInterface {
    @GET("v1/json/1/lookupevent.php?id=441613")
    Call<EventList> doGetEvent();
}
