package com.example.borrower_activity_test;

import java.io.Serializable;


public class UserEvent implements Serializable {
    private String userName;
    private int uid;

    public UserEvent(String userName, int uid) {
        this.userName = userName;
        this.uid = uid;
    }

    public UserEvent() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


}


