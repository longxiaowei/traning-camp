package com.longxw.ObserverPattern.observer;

public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        this.readMsg();
    }

    public void readMsg(){
        System.out.println(name + " 收到推送消息： " + message);
    }
}
