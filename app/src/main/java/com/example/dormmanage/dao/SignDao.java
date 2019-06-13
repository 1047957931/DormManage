package com.example.dormmanage.dao;
import  com.example.dormmanage.model.Sign;
import java.util.List;

public interface SignDao {
    //查询所有楼层
    List<Number> selectAllUsers();
    //条件查询
    Number select(String Number);
    List<Number>selectByCost(int cost);
    //增删改一个楼层
    void insert(Number number);
    void update(Number number);
    void delete(String number );
}