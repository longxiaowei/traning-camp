package com.longxw.pattern.strategy.handler;

import java.io.File;

public class DocHandler implements HandlerInterface{

    private String type = "doc";

    @Override
    public String readContent(File file) {
        return "doc";
    }

    @Override
    public String getType() {
        return type;
    }
}
