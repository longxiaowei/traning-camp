package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;

@HandlerType("pdf")
public class PdfHandler extends AbstractHandler{
    public String handler(String type) {
        System.out.println("read pdf as text,type:"+type);
        return "success";
    }
}
