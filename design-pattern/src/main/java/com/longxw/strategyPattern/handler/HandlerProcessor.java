package com.longxw.strategyPattern.handler;

import com.longxw.strategyPattern.annotation.HandlerType;
import com.longxw.util.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private String basePackage = "com.longxw";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String,Class> handleMap = new HashMap<>();
        ClassScaner.scan(basePackage,HandlerType.class).forEach(clazz ->{
            String value = clazz.getAnnotation(HandlerType.class).value();
            handleMap.put(value,clazz);
        });
        HandlerContext context = new HandlerContext(handleMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(),context);
    }
}