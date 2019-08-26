package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;

@HandlerType("doc")
public class DocHandler implements HandlerInterface{
    public String handler(String type) {
        System.out.println("read Doc as text,type:"+type);
        return "hello word";
    }
}
