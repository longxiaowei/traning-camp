package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;

import java.io.File;

@HandlerType("pdf")
public class PdfHandler extends AbstractHandler{
    public String handler(File file) {
        System.out.println("read pdf as txt");
        return "success";
    }
}
