package com.longxw.strategyPattern.controller;

import com.longxw.strategyPattern.api.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    IStrategy iStrategy;

    @GetMapping("/test")
    public String test(){
        File file = new File("D:/logs/gateway.log");
        return iStrategy.readContext(file);
    }
}
