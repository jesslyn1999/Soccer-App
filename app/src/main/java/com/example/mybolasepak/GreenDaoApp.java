package com.example.mybolasepak;

import android.app.Application;

import com.example.mybolasepak.database.model.DaoMaster;
import com.example.mybolasepak.database.model.DaoSession;

import lombok.Data;

@Data
public class GreenDaoApp extends Application {
    private static final String DB_NAME = "mysepakbola.db";
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        daoSession = DaoMaster.newDevSession(this, DB_NAME);
    }
}
