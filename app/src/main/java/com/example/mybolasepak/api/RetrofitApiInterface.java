package com.example.mybolasepak.api;

import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.model.ListEvent;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {
    @GET("v1/json/1/lookupevent.php?id=441613")
    Call<ListEvent> doGetEvent();
}
