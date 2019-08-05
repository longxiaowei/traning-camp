package com.longxw.strategyPattern.api.impl;

import com.longxw.strategyPattern.api.IStrategy;
import com.longxw.strategyPattern.handler.AbstractHandler;
import com.longxw.strategyPattern.handler.HandlerContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

@Component
public class StrategyImpl implements IStrategy {

    @Resource
    HandlerContext<AbstractHandler> handlerContext;

    public String readContext(File file) {
        return handlerContext.getHandler(this.getFileType()).handler(file);
    }

    private String getFileType(){
        return "doc";
    }
}
