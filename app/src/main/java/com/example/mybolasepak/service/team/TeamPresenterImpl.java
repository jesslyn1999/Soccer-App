package com.example.mybolasepak.service.team;

import android.util.Log;

import com.example.mybolasepak.modellist.Team;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;

public class TeamPresenterImpl implements MainInterface.presenter, MainInterface.GetIntractor.OnFinishedListener<Team> {

    private static final String TAG = "TeamPresenterImpl";

    private MainInterface.MainView<Team> mainView;
    private MainInterface.GetIntractor<Team> getIntractor;

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
    public void onFinished(ArrayList<Team> dataList) {
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
