package com.longxw.strategyPattern.handler;
import java.util.Map;

public class HandlerContext {

    private Map<String,HandlerInterface> handleMap;

    public HandlerContext(Map<String,HandlerInterface> handleMap){
        this.handleMap = handleMap;
    }

    public HandlerInterface getHandler(String type){
        HandlerInterface clazz = handleMap.get(type);
        if(clazz == null){
            throw new RuntimeException("not found handler for type:"+type);
        }
        return clazz;
    }

}
