package com.longxw.pattern.strategy.api.impl;

import com.longxw.pattern.strategy.api.IStrategy;
import com.longxw.pattern.strategy.handler.HandlerContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StrategyImpl implements IStrategy {

    @Resource
    HandlerContext handlerContext;

    public String readContext(String type) {
        return handlerContext.getHandler(type).handler(type);
    }

}
