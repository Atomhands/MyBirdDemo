package com.iweb.test;

public class UserAction {

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public void show() {
        System.out.println("show " + user);
    }

}
