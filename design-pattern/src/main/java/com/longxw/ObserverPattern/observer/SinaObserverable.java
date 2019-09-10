package com.longxw.ObserverPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class SinaObserverable implements Observerable{

    private List<Observer> list;
    private String message;

    public SinaObserverable() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.list.remove(o);
    }

    @Override
    public void notifyObserver() {
        list.stream().forEach(item -> {
            item.update(message);
        });
    }

    public void setMessage(String message){
        this.message = message;
        this.notifyObserver();
    }

}
