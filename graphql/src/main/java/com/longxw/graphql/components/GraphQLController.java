package com.longxw.graphql.components;

import com.longxw.graphql.api.ExecutionResultHandler;
import com.longxw.graphql.GraphQLInvocation;
import com.longxw.graphql.GraphQLInvocationData;
import graphql.ExecutionResult;
import graphql.Internal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.concurrent.CompletableFuture;

/**
 * @author longxw
 * @since 2020/4/7
 */
@RestController
@Internal
public class GraphQLController {


    private final GraphQLInvocation graphQLInvocation;

    private final ExecutionResultHandler executionResultHandler;

    public GraphQLController(GraphQLInvocation graphQLInvocation, ExecutionResultHandler executionResultHandler){
        this.graphQLInvocation = graphQLInvocation;
        this.executionResultHandler = executionResultHandler;
    }

    @PostMapping("/graphql")
    public Object query(@RequestBody GraphQLInvocationData invocationData, WebRequest webRequest){
        CompletableFuture<ExecutionResult> executionResult = graphQLInvocation.invoke(invocationData, webRequest);
        return executionResultHandler.handleExecutionResult(executionResult);
    }

}
