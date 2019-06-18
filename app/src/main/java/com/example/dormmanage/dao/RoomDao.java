package com.example.dormmanage.dao;

import com.example.dormmanage.model.Room;

import java.util.List;

import com.example.dormmanage.model.Room;

public interface RoomDao {
    // 查询所有的宿舍
    List<Room> selectAllRooms();

    // 根据宿舍名查询
    Room select(String roomName);

    // 查询所有未住满的宿舍
    List<Room> selectByNumber();

    // 增删改一个宿舍
    void insert(Room room);
    void update(Room room);
    void delete(String roomName);
}
