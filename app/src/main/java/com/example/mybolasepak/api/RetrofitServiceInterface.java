package com.example.mybolasepak.api;

import com.example.mybolasepak.model.EventList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServiceInterface {
    @GET("v1/json/1/lookupevent.php?id=441613")
    Call<EventList> getEventListById();

    @GET("v1/json/1/lookupteam.php?id=133604")
    Call<EventList> getTeamListById();

    @GET("v1/json/1/eventsnext.php?id=133602")
    Call<EventList> getNext5EventListByTeamId();

    @GET("v1/json/1/eventslast.php?id=133602")
    Call<EventList> getLast5EventListByTeamId();
}
