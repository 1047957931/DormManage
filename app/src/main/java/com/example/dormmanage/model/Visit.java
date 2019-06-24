package com.example.dormmanage.model;

import java.io.Serializable;

public class Visit implements Serializable {
    private int id;
    private String VisitName;
    private String VisitTime;
    private String VisitTel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitName() {
        return VisitName;
    }

    public void setVisitName(String visitName) {
        this.VisitName = visitName;
    }

    public String getVisitTime() {
        return VisitTime;
    }

    public void setVisitTime(String visitTime) {
        this.VisitTime = visitTime;
    }

    public String getVisitTel() {
        return VisitTel;
    }

    public void setVisitTel(String visitTel) {
        this.VisitTel = visitTel;
    }

    @Override
    public String toString() {
        return "Visit{" +
                ", VisitName='" + VisitName + '\'' +
                ", VisitTime='" + VisitTime + '\'' +
                ", VisitTel='" + VisitTel + '\'' +
                '}';
    }
}
