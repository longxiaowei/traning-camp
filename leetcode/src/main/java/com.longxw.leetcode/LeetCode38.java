package com.longxw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println("***********************start*************************");
        get(10);
        System.out.println("************************end**************************");
    }

    public static String get(Integer index){
        if(index == 1){
            System.out.println(1);
            return "1";
        }
        return getString(get(index-1));
    }

    public static String getString(String s){
        char[] chars = s.toCharArray();
        String temp;
        List<Map<String, Integer>> list = new ArrayList<>();
        for(int i = 0;i<chars.length; i++){
            String value =  chars[i] + "";
            if(i == 0){
                Map<String, Integer> map = new HashMap<>();
                map.put(value, 1);
                list.add(map);
            }else{
                temp = chars[i-1] + "";
                if(value.equals(temp)){
                    list.get(list.size()-1).put(value, list.get(list.size()-1).get(value) + 1);
                }else{
                    Map<String, Integer> map = new HashMap<>();
                    map.put(value, 1);
                    list.add(map);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(Map<String, Integer> map : list){
            map.forEach((k,v) -> {
                result.append(v).append(k);
            });
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
