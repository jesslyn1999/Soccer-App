package com.example.mybolasepak.service;

import android.util.Log;

import com.example.mybolasepak.model.EventList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventPresenterImpl implements MainInterface.presenter, MainInterface.GetIntractor.OnFinishedListener<EventList> {
    private static final String TAG = "EventPresenterImpl";

    private MainInterface.MainView<EventList> mainView;
    private MainInterface.GetIntractor getIntractor;

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        getIntractor.getDataList(this);
    }

    @Override
    public void requestDataFromServer() {
        Log.i(TAG, "Start Executing RequestDataFrom Server");
        getIntractor.getDataList(this);
    }

    @Override
    public void onFinished(ArrayList<EventList> dataList) {
        if (mainView != null) {
            mainView.setDataToRecyclerView(dataList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
