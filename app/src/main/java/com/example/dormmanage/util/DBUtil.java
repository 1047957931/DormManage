package com.example.dormmanage.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {

    private final String TBL_sign = "CREATE TABLE IF NOT EXISTS t_sign(" +
            " id integer  PRIMARY KEY AUTOINCREMENT," +
            " number integer NOT NULL ," +
            " passward varchar(8) NOT NULL )";

    public DBUtil( Context context,  int version) {
        super(context, "demo.db",null, version);
    }

    //当app发现没有demo，db会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_sign);
    }
    //当app发现有demo，db时，而且verion有变化时会自动调用onUpgrade更新数据库表

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists t_sign");
        onCreate(db);
    }
}
