package com.longxw.graphql.provider;

import com.longxw.graphql.annotation.GraphqlMutation;
import com.longxw.graphql.annotation.GraphqlQuery;
import com.longxw.graphql.api.DataFetcherService;
import com.longxw.graphql.common.DataFetcherWrapper;
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
        /**
         * TODO 暂时直接使用 ASM 通过字节码获取方法的参数名称
         * 改进 此处应参考 springmvc 参数绑定原理
         * 定义相应的参数解析器 参考 AbstractArgResolver
         * 循环可用的解析器，全部都无法解析最后选择 ASM 解析
         * 并将改方法 使用的解析器缓存起来，下一次 直接使用对应的解析器解析
         */
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
