package com.example.mybolasepak.api;

import com.example.mybolasepak.model.EventList;
import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.model.TeamList;
import com.example.mybolasepak.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServiceInterface {
    @GET("v1/json/1/lookupevent.php")
    Call<EventList> getEventById(@Query("id") String eventID);

    @GET("v1/json/1/lookupteam.php")
    Call<Team> getTeamById(@Query("id") String teamID);

    @GET("v1/json/1/eventsnext.php")
    Call<EventList> getNext5EventsByTeamId(@Query("id") String teamID);

    @GET("v1/json/1/eventslast.php")
    Call<EventList> getLast5EventsByTeamId(@Query("id") String teamID);
}
