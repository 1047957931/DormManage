package com.example.dormmanage.service;

import com.example.dormmanage.model.Visit;

import java.util.List;

public interface VisitService {
    public List<Visit> getAllVisits();
    public void insert(Visit visit);
    public void modifyRealNumber(Visit visit);
    public void delete(String visitName);
}
