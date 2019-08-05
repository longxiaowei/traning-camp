package com.longxw.strategyPattern.handler;
import java.util.Map;

public class HandlerContext<T> {

    private Map<String,T> handleMap;

    public HandlerContext(Map<String,T> handleMap){
        this.handleMap = handleMap;
    }

    public T getHandler(String type){
        T handler = handleMap.get(type);
        if(handler == null){
            throw new RuntimeException("not found handler for type:"+type);
        }
        return handleMap.get(type);
    }

}
