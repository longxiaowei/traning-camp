package com.longxw.graphql.provider;

import com.longxw.graphql.util.IOUtils;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * @author longxw
 * @since 2020/4/1
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    @PostConstruct
    public void init() throws IOException {
        try(InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("graphql/demo.graphql")){
            String sdl = IOUtils.readToString(inputStream);
            GraphQLSchema graphQLSchema = buildSchema(sdl);
            this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        }
    }

    private GraphQLSchema buildSchema(String sdl) {
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry  = schemaParser.parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                .type(newTypeWiring("Book")
                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .build();
    }

}
