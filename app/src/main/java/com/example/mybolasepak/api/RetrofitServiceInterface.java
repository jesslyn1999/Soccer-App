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

    @GET("v1/json/1/lookupteam.php")
    Call<TeamList> getTeamListById(@Query("id") long id);

    @GET("v1/json/1/lookupteam.php?id=133604")
    Call<TeamList> test();

    @GET("v1/json/1/eventsnextleague.php?id=4328")
    Call<EventList> getNext15EventListByLeagueId();

    @GET("v1/json/1/eventspastleague.php?id=4328")
    Call<EventList> getLast15EventListByLeagueId();

//    @GET("v1/json/1/lookupevent.php")
//    Call<EventList> getEventListById(@Query("id") String id);  // id=441613
//
//    @GET("v1/json/1/lookupteam.php")
//    Call<TeamList> getTeamListById(@Query("id") String id);  // id=133604
//
//    @GET("v1/json/1/eventsnext.php")
//    Call<EventList> getNext5EventListByTeamId(@Query("id") String id);  // id=133602
//
//    @GET("v1/json/1/eventslast.php")
//    Call<EventList> getLast5EventListByTeamId(@Query("id") String id);  // id=133602
}
