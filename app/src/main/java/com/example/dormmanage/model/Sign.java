package com.example.dormmanage.model;

import java.io.Serializable;

public class Sign implements Serializable {
    private String number;
    private String password;

    public Sign(){

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
