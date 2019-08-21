package com.longxw.strategyPattern.lambda;

import java.io.File;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StrategyLambda {

    private static String getTextByFunction(File file,Function<File,String> function){
        return function.apply(file);
    }

    private static void printFileName(File file, Consumer<File> consumer){
        consumer.accept(file);
    }

    private static boolean isPdf(File file, Predicate<File> predicate){
        return predicate.test(file);
    }

    private static <T> T getClazz(Supplier<T> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {

        File file1 = new File("/");

        StrategyLambda.getClazz(()-> new StrategyLambda());

        StrategyLambda.printFileName(file1,(file)->System.out.println(file.getName()));

        StrategyLambda.isPdf(file1,(file -> file.getName().lastIndexOf("pdf")>0));

        StrategyLambda.getTextByFunction(file1,(file -> file.getName()));

    }
}
