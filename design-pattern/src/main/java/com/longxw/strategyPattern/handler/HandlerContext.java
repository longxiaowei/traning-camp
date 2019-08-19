package com.longxw.strategyPattern.handler;
import java.util.Map;

public class HandlerContext<T> {

    private Map<String,AbstractHandler> handleMap;

    public HandlerContext(Map<String,AbstractHandler> handleMap){
        this.handleMap = handleMap;
    }

    public AbstractHandler getHandler(String type){
        AbstractHandler t = handleMap.get(type);
        if(t == null){
            throw new RuntimeException("not found handler for type:"+type);
        }
        return t;
    }

}
