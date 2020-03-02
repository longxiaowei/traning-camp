package com.longxw.traning.predicates;

import java.util.function.Predicate;

public class Predicates {

    public Predicate<String> test1(String s){
        s = s + "1";
        return a -> {
            return a.lastIndexOf("1")>0;
        };
    }


    public static void main(String[] args) {
        Predicates p = new Predicates();
        System.out.println(p.test1("cs").test("cs"));
    }

}
