package com.longxw.traning.reactor;

import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class FluxDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> mapper = i -> i * i;
        Flux.just(1,2,3,4,5).subscribe(new CoreSubscriber<Object>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(6);
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

}
