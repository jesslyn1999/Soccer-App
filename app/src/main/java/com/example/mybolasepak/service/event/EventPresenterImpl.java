package com.example.mybolasepak.service.event;

import android.util.Log;

import com.example.mybolasepak.database.model.EventDbModel;
import com.example.mybolasepak.service.MainInterface;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EventPresenterImpl implements MainInterface.presenter, MainInterface.GetIntractor.OnFinishedListener<EventDbModel> {
    private static final String TAG = "EventPresenterImpl";

    private MainInterface.MainView<EventDbModel> mainView;
    private MainInterface.GetIntractor<EventDbModel> getIntractor;

    private List<EventDbModel> eventDbModelList;

    public EventPresenterImpl(MainInterface.MainView mainView, MainInterface.GetIntractor getIntractor) {
        this.mainView = mainView;
        this.getIntractor = getIntractor;
        eventDbModelList = new ArrayList<>();
    }


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
    public void onFinished(ArrayList<EventDbModel> dataList) {
        eventDbModelList = dataList;
        if (mainView != null) {
            mainView.setDataToRecyclerView(dataList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        Log.e(TAG, "Error in onFailure while requesting data from server");
    }
}
