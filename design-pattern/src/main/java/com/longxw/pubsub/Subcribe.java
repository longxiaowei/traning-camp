package com.longxw.pubsub;

public interface Subcribe {

    void subcribe(SubscribePublish subscribePublish);
    void unsubcribe(SubscribePublish subscribePublish);
    void update(SubscribePublish.Msg ms);
}
