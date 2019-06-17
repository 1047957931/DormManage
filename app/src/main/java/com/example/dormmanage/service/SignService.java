package com.example.dormmanage.service;

import android.content.Context;

import com.example.dormmanage.dao.SignDao;
import com.example.dormmanage.dao.SignDaoImpl;
import com.example.dormmanage.model.Sign;

public class SignService {
    private SignDao dao;
    public SignService(Context context) {
        this.dao = new SignDaoImpl(context);
    }
//1.完成登录功能
    public boolean login(Sign sign) {
        Sign s = dao.select(sign.getNumber());
        if(s != null && s.getPassword().equals(sign.getPassword())) {
            return true;
        }
        return  false;
    }
//2.完成注册功能

    public boolean register(Sign sign) {
        Sign s=dao.select(sign.getNumber());
        if (s==null){
            dao.insert(sign);
            return true;
        }
        return false;
    }
}
