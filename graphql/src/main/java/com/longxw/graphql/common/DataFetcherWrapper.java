package com.longxw.graphql.common;

import lombok.Data;

import java.lang.reflect.Method;

@Data
public class DataFetcherWrapper {
    private String type;
    private Method method;
    private String name;
}
