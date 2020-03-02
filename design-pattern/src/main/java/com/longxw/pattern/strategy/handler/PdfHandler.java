package com.longxw.pattern.strategy.handler;

import java.io.File;

public class PdfHandler implements HandlerInterface{

    private String type = "Pdf";

    @Override
    public String readContent(File file) {
        return "pdf";
    }

    @Override
    public String getType() {
        return type;
    }
}
