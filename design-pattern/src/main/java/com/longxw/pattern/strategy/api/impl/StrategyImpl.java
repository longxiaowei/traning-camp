package com.longxw.pattern.strategy.api.impl;

import com.longxw.pattern.strategy.api.IStrategy;
import com.longxw.pattern.strategy.handler.HandlerContext;
import com.longxw.pattern.strategy.handler.HandlerInterface;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StrategyImpl implements IStrategy {

    @Resource
    HandlerContext handlerContext;

    @Override
    public String readContext(String type) {
        HandlerInterface handlerInterface = handlerContext.get(type);
        return "";
    }

}
