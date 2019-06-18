package com.example.dormmanage.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBUtil extends SQLiteOpenHelper {

    private final String TBL_sign = "CREATE TABLE IF NOT EXISTS t_sign(" +
            " id integer  PRIMARY KEY AUTOINCREMENT," +
            " number varchar(20) NOT NULL ," +
            " password varchar(8) NOT NULL )";

    public final String TBL_room = "create table if not exists t_room(" +
            "id integer primary key autoincrement, " +
            "room_name varchar(20), " +
            "expect_number integer, " +
            "real_number integer, " +
            "cost integer)";


    public DBUtil( Context context) {
        super(context, "demo.db",null, 2);
    }

    //当app发现没有demo，db会自动调用onCreate创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_sign);
        db.execSQL(TBL_room);
    }
    //当app发现有demo，db时，而且version有变化时会自动调用onUpgrade更新数据库表

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists t_sign");
        db.execSQL("drop table if exists t_room");
        onCreate(db);
    }
}
