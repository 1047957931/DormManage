package com.example.dormmanage.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanage.model.Sign;
import com.example.dormmanage.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class SignDaoImpl implements SignDao{
    private DBUtil helper;
    private SQLiteDatabase db;

    public SignDaoImpl(Context context){

        //调用DBHelper类的构造方法时
        // 如发现demo.db不存在会调用onCreate创建
        //若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        helper= new DBUtil( context,1 );


    }

    @Override
    public List<Sign> selectAllUsers() {
//        List<Room> rooms = null;
//        //1、获取SQLiteDateBase对象
//        db = helper.g
//        //2、查询etReadableDatabase();
//        String sql = "select * from t_room";
//        Cursor cursor = db.rawQuery( sql,null );//跟Result类似
//        //3、处理结果
//        if (cursor!=null&&cursor.getCount()>0){
//
//            rooms = new ArrayList<>(  );
//            while (cursor.moveToNext()){
//                Room room = new Room(  );
//                room.setRoomName( cursor.getString( cursor.getColumnIndex( "room_name" ) ) );
//                room.setExpectNumber( cursor.getInt( cursor.getColumnIndex( "expect_number" ) ) );
//                rooms.add( room );
//            }
//
//            //关闭cursor
//            cursor.close();
        return null;
    }

    @Override
    public Sign select(String number) {
        Sign sign = null;
        db = helper.getReadableDatabase();
        //2、查询
        String sql = "select * from t_sign where number=?";
        Cursor cursor = db.rawQuery( sql, new String[]{String.valueOf(number)} );//跟Result类似
        //3、处理结果
        if (cursor!=null&&cursor.getCount()>0) {
            if (cursor.moveToNext()) {
                sign = new Sign();
                sign.setNumber(cursor.getString(cursor.getColumnIndex("number")));
                sign.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            }

            //关闭cursor
            cursor.close();
        }
        db.close();
        return sign;
    }

    @Override
    public void insert(Sign sign) {
        int count=0;
        //1.获取db对象
        db=helper.getWritableDatabase();
        String sql="insert into t_sign values(null, ?,?)";
        //2.执行sql
        try {
            db.execSQL(sql,new Object[]{
                            sign.getNumber(),
                            sign.getPassword(),
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Sign sign) {

    }

    @Override
    public void delete(String number) {

    }


}
