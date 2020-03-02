package com.longxw.pattern.strategy.lambda;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StrategyLambda {

    @FunctionalInterface
    interface Lambda{
        void invoke();
    }

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

    public static void main(String[] args) throws IOException{
        File file = new File("D:\\company\\mcube\\mcube-applications\\mcube-provider\\src\\main\\resources\\mcube\\data\\graphql");
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(readFile(f));
        }
    }

    public static String readFile(File file) throws IOException{

        Function<Integer, String> function = (i) -> i.toString();

        try(FileReader fileReader = new FileReader(file)) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while( (i = fileReader.read()) != -1){
                sb.append((char)i);
            }
            return sb.toString();
        }
    }

}
