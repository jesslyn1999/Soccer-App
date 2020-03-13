package com.example.mybolasepak.database.helper;

import android.content.Context;

import com.example.mybolasepak.database.model.DaoMaster;

public class DbOpenHelper extends DaoMaster.OpenHelper {

    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

}
