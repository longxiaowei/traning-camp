package com.longxw.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**发布订阅器
 * @author longxw
 * @since 2019-9-10
 */
public class SubscribePublish {

    private String name;
    final int QUEUE_CAPACITY = 20;
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private List<Subcribe> subcribers = new ArrayList<Subcribe>();

    public SubscribePublish(String name){
        this.name = name;
    }

    public void publish(String msg,String name){
        queue.add(new Msg(name,msg));
        this.update();
    }

    public void update(){
        Msg msg = queue.poll();
        while (msg != null){
            for(Subcribe s:subcribers ){
                s.update(msg);
                msg = queue.poll();
            }
        }
    }

    public void subcribe(Subcribe subcribe){
        subcribers.add(subcribe);
    }

    public void unsubcribe(Subcribe subcribe){
        subcribers.remove(subcribe);
    }

    class Msg{
        private String publisher;
        private String message;
        public Msg(String publisher,String message){
            this.message = message;
            this.publisher = publisher;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
