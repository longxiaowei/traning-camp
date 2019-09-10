package com.longxw.pubsub;

public class Subcriber implements Subcribe{

    private String name;

    public Subcriber(String name){
        this.name = name;
    }

    @Override
    public void subcribe(SubscribePublish subscribePublish) {
        subscribePublish.subcribe(this);
    }

    @Override
    public void unsubcribe(SubscribePublish subscribePublish) {
        subscribePublish.unsubcribe(this);
    }

    @Override
    public void update(SubscribePublish.Msg ms) {
        System.out.println(ms.getPublisher()+"对"+this.name+"说："+ms.getMessage());
    }
}
