package com.example.dormmanage.dao;
import  com.example.dormmanage.model.Sign;
import java.util.List;

public interface SignDao {
    //查询所有楼层
    List<Sign> selectAllUsers();
    //条件查询
    Sign select(String number);

    //注册
    int insert(Sign sign);
    //
    void update(Sign sign);
    void delete(String number );
}