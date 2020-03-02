package com.longxw.pattern.strategy.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author longxw
 * @since 2019/12/11
 */
public class HandlerContext implements InitializingBean {

    @Autowired
    List<HandlerInterface> list;

    private Map<String, HandlerInterface> map;

    @Override
    public void afterPropertiesSet() {
        map = new HashMap<>(list.size());
        list.forEach(it -> map.put(it.getType(), it));
    }

    public HandlerInterface get(String type){
        return map.get(type);
    }
}
