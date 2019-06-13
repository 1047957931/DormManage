package com.example.dormmanage.model;

import java.io.Serializable;

public class Sign implements Serializable {
    private int number;
    private char password;

    public Sign(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "number=" + number +
                ", password=" + password +
                '}';
    }
}
