package com.longxw.graphql;

import com.longxw.graphql.api.DataFetcherService;
import com.longxw.graphql.provider.GraphQLDataFetchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLDataFetchers graphQLDataFetchers(@Autowired List<DataFetcherService> list){
        return new GraphQLDataFetchers(list);
    }

}
