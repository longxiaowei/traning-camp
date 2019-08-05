package com.longxw.strategyPattern.api.impl;

import com.longxw.strategyPattern.api.IStrategy;
import com.longxw.strategyPattern.handler.HandlerContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

@Component
public class StrategyImpl implements IStrategy {

    @Resource
    HandlerContext handlerContext;

    public String readContext(String type) {
        return handlerContext.getHandler(type).handler(type);
    }

    private String getFileType(){
        return "doc";
    }
}
