package com.example.mybolasepak.service.event;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.model.EventList;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventGetIntractorsImpl implements MainInterface.GetIntractor<Event> {
    private static final String TAG = "EventGetIntractorImpl";

    @Override
    public void getDataList(OnFinishedListener<Event> onFinishedListener) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<EventList> call = service.getEventListById();
        Log.i(TAG, "Start executing getDataList with request_url=" + call.request().url());

        call.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(@NonNull Call<EventList> call, @NonNull Response<EventList> response) {
                ArrayList<Event> eventList = response.body() != null ? response.body().getEvents() : new ArrayList<>();
                onFinishedListener.onFinished(eventList);
                Log.i(TAG, "Done executing getDataList with length=" + eventList.size() + " and one of the response=" + eventList.get(0).toString());
            }

            @Override
            public void onFailure(@NonNull Call<EventList> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        Log.i(TAG, "Done executing getDataList");

    }
}
