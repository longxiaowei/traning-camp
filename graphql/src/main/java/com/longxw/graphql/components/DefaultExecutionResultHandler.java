package com.longxw.graphql.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.longxw.graphql.ExecutionResultHandler;
import graphql.ExecutionResult;
import graphql.Internal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Internal
public class DefaultExecutionResultHandler implements ExecutionResultHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Object handleExecutionResult(CompletableFuture<ExecutionResult> executionResultCF) {
        return executionResultCF.thenApply(ExecutionResult::toSpecification);
    }
}
