package com.longxw.graphql.provider;

import com.longxw.graphql.annotation.GraphqlMutation;
import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.api.DataFetcherService;
import com.longxw.graphql.common.DataFetcherWrapper;
import graphql.schema.DataFetcher;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author longxw
 * @since 2020/4/1
 */
@Slf4j
public class GraphQLDataFetchers{

    @Getter
    private List<DataFetcherWrapper> dataFetcherWrapperList;

    public GraphQLDataFetchers(List<DataFetcherService> list){
        if (list.isEmpty()) {
            throw new RuntimeException("找不到 DataFetcherService");
        }
        LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        dataFetcherWrapperList = new ArrayList<>(list.size() * 5);
        list.forEach(service -> {
            Method[] methods = service.getClass().getMethods();
            String serviceName = service.getClass().getSimpleName();
            Arrays.stream(methods).forEach(method -> {
                if(method.getAnnotation(GraphqlQuery.class) !=null){
                    dataFetcherWrapperList.add(new DataFetcherWrapper(DataFetcherWrapper.TypeEnum.QUERY, method, serviceName + "_" + method.getName(), service, parameterNameDiscoverer.getParameterNames(method)));
                }else if (method.getAnnotation(GraphqlMutation.class) != null){
                    dataFetcherWrapperList.add(new DataFetcherWrapper(DataFetcherWrapper.TypeEnum.QUERY, method, serviceName + "_" + method.getName(), service, parameterNameDiscoverer.getParameterNames(method)));
                }
            });
        });
    }
}
