package com.example.dormmanage.dao;

import com.example.dormmanage.model.Visit;

import java.util.List;

public interface VisitDao {
    // 查询所有的宿舍
    List<Visit> selectAllVisits();

    // 根据宿舍名查询
    Visit select(String visitName);

    // 查询所有未住满的宿舍
    List<Visit> selectByNumber();

    // 增删改一个宿舍
    void insert(Visit visit);
    void update(Visit visit);
    void delete(String roomName);
}
