package com.example.mybolasepak.service.event;

import android.util.Log;

import com.example.mybolasepak.model.Event;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventPresenterImpl implements MainInterface.presenter, MainInterface.GetIntractor.OnFinishedListener<Event> {
    private static final String TAG = "EventPresenterImpl";

    private MainInterface.MainView<Event> mainView;
    private MainInterface.GetIntractor<Event> getIntractor;

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
    public void onFinished(ArrayList<Event> dataList) {
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
