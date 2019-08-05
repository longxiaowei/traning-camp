package com.longxw.strategyPattern.handler;
import com.longxw.util.SpringBeanTool;

import java.util.Map;

public class HandlerContext {

    private Map<String,Class> handleMap;

    public HandlerContext(Map<String,Class> handleMap){
        this.handleMap = handleMap;
    }

    public AbstractHandler getHandler(String type){
        Class clazz = handleMap.get(type);
        if(clazz == null){
            throw new RuntimeException("not found handler for type:"+type);
        }
        return (AbstractHandler)SpringBeanTool.getBean(clazz);
    }

}
