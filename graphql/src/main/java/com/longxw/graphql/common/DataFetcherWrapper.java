package com.longxw.graphql.common;

import graphql.Assert;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    private String[] parameters;


    public DataFetcherWrapper(TypeEnum type, Method method, String name, Object target, String[] parameters){
        this.type = type;
        this.method = method;
        this.name = Assert.assertNotNull(name);
        this.target = target;
        this.parameters = parameters;
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

        if(this.parameters == null ){
            return null;
        }

        int length = this.parameters.length;
        Object[] args = new Object[length];
        for(int i=0;i<length;i ++ ){
            args[i] = environment.getArgument(parameters[i]);
        }
        return args;
    }

    public enum TypeEnum{
        QUERY,
        MUTATION,
        GETTER;
    }
}
