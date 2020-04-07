package com.longxw.graphql.common;

import graphql.Assert;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.Getter;
import lombok.Setter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Getter
@Setter
public class DataFetcherWrapper {
    private TypeEnum type;
    private Method method;
    private String name;
    private Object target;


    public DataFetcherWrapper(TypeEnum type, Method method, String name, Object target){
        this.type = type;
        this.method = method;
        this.name = Assert.assertNotNull(name);
        this.target = target;
    }

    public DataFetcher getDataFetcher() {
        return (environment) -> DataFetcherResult.newResult().data(this.execute(environment)).build();
    }

    public Object execute(DataFetchingEnvironment environment) throws InvocationTargetException, IllegalAccessException {
        if(this.type == TypeEnum.GETTER){
            return this.method.invoke(environment.getSource());
        }
        return this.method.invoke(target, this.getArgs(environment));
    }

    public Object[] getArgs(DataFetchingEnvironment environment){
        Parameter[] parameters = this.method.getParameters();
        if(parameters.length == 1) {
            return new Object[]{environment.getArgument("id")};
        }
        return null;
    }

    public enum TypeEnum{
        QUERY,
        MUTATION,
        GETTER;
    }
}
