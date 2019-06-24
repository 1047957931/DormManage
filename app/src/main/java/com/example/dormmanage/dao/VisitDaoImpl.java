package com.example.dormmanage.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dormmanage.model.Visit;

import java.util.ArrayList;
import java.util.List;

public class VisitDaoImpl implements VisitDao {
    private DBUtil dbHelper;
    private SQLiteDatabase db;

    public VisitDaoImpl(Context context) {
        // 调用MyDBHelper类的构造方法时，
        // 若发现demo.db不存在会调用onCreate方法创建
        // 若发现demo.db存在，且version的版本与已有的不一致，则调用onUpgrade方法更新
        dbHelper = new DBUtil(context);
    }

    public void insert(Visit visit) {
        db = dbHelper.getWritableDatabase();
        String sql = "insert into t_visit values(null,?,?,?)";
        db.execSQL(sql, new Object[]{
                visit.getVisitName(),
                visit.getVisitTime(),
                visit.getVisitTel()});
        db.close();
    }

    @Override
    public void update(Visit visit) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "update t_visit set visit_time=? where visit_name=?";
        db.execSQL(sql, new Object[]{
                visit.getVisitTime(),
                visit.getVisitName()
        });
    }

    @Override
    public void delete(String VisitName) {
        // 1. 获取db对象
        db = dbHelper.getWritableDatabase();
        // 2. 执行sql
        String sql = "delete from t_visit where visit_name=?";
        db.execSQL(sql, new Object[]{ VisitName });
    }

    public List<Visit> selectAllVisits() {
        String sql = "select * from t_visit";
        List<Visit> visits = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            visits = new ArrayList<>();
            while (cursor.moveToNext()) {
                Visit visit = new Visit();
                visit.setVisitName(cursor.getString(cursor.getColumnIndex("visit_name")));
                visit.setVisitTime(cursor.getString(cursor.getColumnIndex("visit_time")));
                visit.setVisitTel(cursor.getString(cursor.getColumnIndex("visit_tel")));

                visits.add(visit);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return visits;
    }

    @Override
    public Visit select(String VisitName) {
        String sql = "select * from t_visit where visit_name=?";
        Visit visit = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToNext()) {
                visit = new Visit();
                visit.setId(cursor.getInt(cursor.getColumnIndex("id")));
                visit.setVisitName(cursor.getString(cursor.getColumnIndex("visit_name")));
                visit.setVisitTime(cursor.getString(cursor.getColumnIndex("visit_time")));
                visit.setVisitTel(cursor.getString(cursor.getColumnIndex("visit_tel")));
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return visit;
    }

    @Override
    public List<Visit> selectByNumber() {
        String sql = "select * from t_visit where expect_number > real_number";
        List<Visit> visits = null;

        // 1. 获取SQLiteDatabase对象
        db = dbHelper.getReadableDatabase();

        // 2. 执行SQL查询
        // Cursor cursor = db.query(Student.TBL_NAME, null, null, null, null, null, null);
        Cursor cursor = db.rawQuery(sql, null);

        // 3. 处理结果
        if (cursor != null && cursor.getCount() > 0) {
            visits = new ArrayList<>();
            while (cursor.moveToNext()) {
                Visit visit = new Visit();
                visit.setId(cursor.getInt(cursor.getColumnIndex("id")));
                visit.setVisitName(cursor.getString(cursor.getColumnIndex("visit_name")));
                visit.setVisitTime(cursor.getString(cursor.getColumnIndex("visit_time")));
                visit.setVisitTel(cursor.getString(cursor.getColumnIndex("visit_tel")));

                visits.add(visit);
            }
            // 4. 关闭cursor
            cursor.close();
        }
        db.close();
        // 5. 返回结果
        return visits;
    }
}
