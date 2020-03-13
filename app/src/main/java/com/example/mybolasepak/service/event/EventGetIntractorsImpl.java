package com.example.mybolasepak.service.event;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.database.model.TeamDbModel;
import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.model.EventList;
import com.example.mybolasepak.model.TeamList;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventGetIntractorsImpl implements MainInterface.GetIntractor<EventDbModel> {
    private static final String TAG = "EventGetIntractorImpl";

    @Override
    public void getDataList(OnFinishedListener<EventDbModel> onFinishedListener) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<EventList> callNextEvents = service.getNext15EventListByLeagueId();
        Call<EventList> callLastEvents = service.getLast15EventListByLeagueId();
        Log.i(TAG, "Start executing getDataList with next_request_url=" +
                callNextEvents.request().url() + " last_request_url=" + callNextEvents.request().url());

        callNextEvents.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(@NonNull Call<EventList> call, @NonNull Response<EventList> response) {
                ArrayList<EventDbModel> eventList = response.body() != null ? response.body().getEvents() : new ArrayList<>();
                onFinishedListener.onFinished(eventList);
                Log.i(TAG, "Done executing getDataList NEXT with length=" + eventList.size() + " and one of the response=" + eventList.get(0).toString());
            }

            @Override
            public void onFailure(@NonNull Call<EventList> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        callLastEvents.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(@NonNull Call<EventList> call, @NonNull Response<EventList> response) {
                ArrayList<EventDbModel> eventList = response.body() != null ? response.body().getEvents() : new ArrayList<>();
                Log.i(TAG, "Done executing getDataList LAST with length=" + eventList.size() + " and one of the response=" + eventList.get(0).toString());
                onFinishedListener.onFinished(eventList);
            }

            @Override
            public void onFailure(@NonNull Call<EventList> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        Log.i(TAG, "Done executing getDataList");

    }
}
