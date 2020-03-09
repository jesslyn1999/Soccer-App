package com.example.mybolasepak.service;

import android.util.Log;

import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.model.EventList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventArrayListService implements MainContract.GetIntractor {
    private static final String TAG = "EventArrayListService";

    @Override
    public void getDataList(OnFinishedListener onFinishedListener) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<EventList> call = service.doGetEvent();
        Log.i(TAG, "Start executing getDataList with request_url=" + call.request().url());

        call.enqueue(new Callback<EventList>() {
            @Override
            public void onResponse(Call<EventList> call, Response<EventList> response) {
                onFinishedListener.onFinished(response.body().getEvents());
            }

            @Override
            public void onFailure(Call<EventList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        Log.i(TAG, "Done executing getDataList");

    }
}
