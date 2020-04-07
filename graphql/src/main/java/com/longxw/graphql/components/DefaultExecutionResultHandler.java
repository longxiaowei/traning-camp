package com.longxw.graphql.components;

import com.longxw.graphql.api.ExecutionResultHandler;
import graphql.ExecutionResult;
import graphql.Internal;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author longxw
 * @since 2020/4/7
 */
@Component
@Internal
public class DefaultExecutionResultHandler implements ExecutionResultHandler {

    @Override
    public Object handleExecutionResult(CompletableFuture<ExecutionResult> executionResultCF) {
        return executionResultCF.thenApply(ExecutionResult::toSpecification);
    }
}
