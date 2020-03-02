package com.longxw.pattern.strategy.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface HandlerType {
    String value();
}
