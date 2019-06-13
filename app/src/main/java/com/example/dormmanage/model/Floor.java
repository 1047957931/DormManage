package com.example.dormmanage.model;

import java.io.Serializable;

public class Floor implements Serializable {
    private int floor;
    private char manager;
    private int number;

    public Floor(){

    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public char getManager() {
        return manager;
    }

    public void setManager(char manager) {
        this.manager = manager;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floor=" + floor +
                ", manager=" + manager +
                ", number=" + number +
                '}';
    }
}
