package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;
import org.springframework.stereotype.Component;

@Component
@HandlerType("doc")
public class DocHandler extends AbstractHandler{
    public String handler(String type) {
        System.out.println("read Doc as text,type:"+type);
        return "hello word";
    }
}