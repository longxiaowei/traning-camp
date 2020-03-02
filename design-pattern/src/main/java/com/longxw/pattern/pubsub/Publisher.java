package com.longxw.pattern.pubsub;

public class Publisher implements Publish{

    private String name;

    public Publisher(String name){
        this.name = name;
    }

    @Override
    public void publish(SubscribePublish subscribePublish,String msg) {
        subscribePublish.publish(msg,this.name);
    }
}
