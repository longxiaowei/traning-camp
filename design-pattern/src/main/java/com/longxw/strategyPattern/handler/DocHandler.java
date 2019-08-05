package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;

import java.io.File;

@HandlerType("doc")
public class DocHandler extends AbstractHandler{
    public String handler(File file) {
        System.out.println("read doc as txt");
        return "hello word";
    }
}
