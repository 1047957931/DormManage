package com.example.dormmanage.service;


import android.content.Context;

import com.example.dormmanage.dao.VisitDao;
import com.example.dormmanage.dao.VisitDaoImpl;
import com.example.dormmanage.model.Visit;

import java.util.List;

public class VisitServiceImpl implements VisitService {
    private VisitDao visitDao;

    public VisitServiceImpl(Context context) {
        visitDao = new VisitDaoImpl(context);

    }

    @Override
    public List<Visit> getAllVisits() {
        return visitDao.selectAllVisits();
    }

    @Override
    public void insert(Visit visit) {
visitDao.insert(visit);
    }

    @Override
    public void modifyRealNumber(Visit visit) {
visitDao.update(visit);
    }

    @Override
    public void delete(String visitName) {
visitDao.delete(visitName);
    }
}
