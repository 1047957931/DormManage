package com.example.dormmanage.service;

import java.util.List;

import com.example.dormmanage.model.Room;

public interface RoomService {
    public List<Room> getAllRooms();
    public void insert(Room room);
    public void modifyRealNumber(Room room);
    public void delete(String roomName);
}
