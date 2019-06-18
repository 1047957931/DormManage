package com.example.dormmanage.service;

import android.content.Context;

import java.util.List;

import com.example.dormmanage.dao.RoomDao;
import com.example.dormmanage.dao.RoomDaoImpl;
import com.example.dormmanage.model.Room;
import com.example.dormmanage.service.RoomService;

public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao;

    public RoomServiceImpl(Context context) {
        roomDao = new RoomDaoImpl(context);
    }

    public List<Room> getAllRooms() {
        return roomDao.selectAllRooms();
    }

    public void insert(Room room) {
        roomDao.insert(room);
    }

    @Override
    public void modifyRealNumber(Room room) {
        roomDao.update(room);
    }

    @Override
    public void delete(String roomName) {
        roomDao.delete(roomName);
    }
}
