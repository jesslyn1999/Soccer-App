package com.example.mybolasepak.service;

import java.util.ArrayList;

public interface MainContract {
    /**
     * Call when user interact with the view and other when view OnDestroy()
     */
    interface presenter {
        void onDestroy();
        void onRefreshButtonClick();
        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView<T> {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(ArrayList<T> DataList);
        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetIntractor {
        interface OnFinishedListener<T> {
            void onFinished(ArrayList<T> dataList);
            void onFailure(Throwable t);
        }
        void getDataList(OnFinishedListener onFinishedListener);
    }
}
