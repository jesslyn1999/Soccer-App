package com.example.mybolasepak.service.team;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mybolasepak.api.RetrofitClientApi;
import com.example.mybolasepak.api.RetrofitServiceInterface;
import com.example.mybolasepak.model.Team;
import com.example.mybolasepak.model.TeamList;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamGetIntractorImpl implements MainInterface.GetIntractor<Team> {

    private static final String TAG = "EventGetIntractorImpl";

    @Override
    public void getDataList(MainInterface.GetIntractor.OnFinishedListener<Team> onFinishedListener) {
        RetrofitServiceInterface service = RetrofitClientApi.getInstance().create(RetrofitServiceInterface.class);
        Call<TeamList> call = service.getTeamListById();
        Log.i(TAG, "Start executing getDataList with request_url=" + call.request().url());

        call.enqueue(new Callback<TeamList>() {
            @Override
            public void onResponse(@NonNull Call<TeamList> call, @NonNull Response<TeamList> response) {
                ArrayList<Team> teamList = response.body() != null ? response.body().getTeams() : new ArrayList<>();
                onFinishedListener.onFinished(teamList);
                Log.i(TAG, "Done executing getDataList with length=" + teamList.size() + " and one of the response=" + teamList.get(0).toString());
            }

            @Override
            public void onFailure(@NonNull Call<TeamList> call, @NonNull Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

        Log.i(TAG, "Done executing getDataList");

    }
}