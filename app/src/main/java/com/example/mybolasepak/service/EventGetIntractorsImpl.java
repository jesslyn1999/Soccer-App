package com.example.mybolasepak.service;

import android.util.Log;

import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.model.EventList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventGetIntractorsImpl implements MainInterface.GetIntractor {
    private static final String TAG = "EventArrayListService";

    @Override
    public void getDataList(OnFinishedListener onFinishedListener) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<EventList> call = service.getEventListById();
        Log.i(TAG, "Start executing getDataList with request_url=" + call.request().url());

        call.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(Call<EventList> call, Response<EventList> response) {
                ArrayList<Event> eventList = response.body().getEvents();
                onFinishedListener.onFinished(eventList);
                Log.i(TAG, "Done executing getDataList with length=" + eventList.size() + " and one of the response=" + eventList.get(0).toString());
            }

            @Override
            public void onFailure(Call<EventList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        Log.i(TAG, "Done executing getDataList");

    }
}
