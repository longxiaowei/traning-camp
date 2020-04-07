package com.longxw.graphql.provider;

import com.longxw.graphql.annotation.GraphqlMutation;
import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.api.DataFetcherService;
import com.longxw.graphql.common.DataFetcherWrapper;
import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author longxw
 * @since 2020/4/1
 */
@Slf4j
public class GraphQLDataFetchers{

    private Map<String, DataFetcherWrapper> map;

    public GraphQLDataFetchers(List<DataFetcherService> list){
        if (list.isEmpty()) {
            throw new RuntimeException("找不到 DataFetcherService");
        }

        list.forEach(service -> {
            Method[] methods = service.getClass().getMethods();
            Arrays.stream(methods).forEach(method -> {
                if(method.getAnnotation(GraphqlQuery.class) !=null){

                }else if (method.getAnnotation(GraphqlMutation.class) != null){

                }else{
                    log.info("{} 类的 {} 方法未找到 @GraphqlQuery 或 @GraphqlMutation 注解", service.getClass().getSimpleName(), method.getName());
                }
            });
        });
    }
}
