package com.example.dormmanage.dao;

import com.example.dormmanage.model.Floor;

import java.util.List;

public interface FloorDao {
    //查询所有楼层
    List<Floor> selectAllRooms();
    //条件查询
   // Floor select(String FloorName);
   // List<Floor>selectByCost(int cost);
    //增删改一个楼层
    void insert(Floor floor);
    void update(Floor floor);
    void delete(String floorName);

}
