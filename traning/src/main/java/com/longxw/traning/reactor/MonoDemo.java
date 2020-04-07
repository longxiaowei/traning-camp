package com.longxw.traning.reactor;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class MonoDemo {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        list.add("a");
        list.add("abc");
        Mono.just(list).subscribe( it -> {
            it.forEach(string -> {
                System.out.println(string.length());
            });
        });
        System.out.println(111);
    }
}
