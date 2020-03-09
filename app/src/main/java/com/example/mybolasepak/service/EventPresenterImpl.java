package com.example.mybolasepak.service;

import com.example.mybolasepak.model.EventList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventPresenterImpl implements MainContract.presenter, MainContract.GetIntractor.OnFinishedListener<EventList> {

    private MainContract.MainView<EventList> mainView;
    private MainContract.GetIntractor getIntractor;

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
