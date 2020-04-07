package com.longxw.traning.order;

import java.util.Arrays;

/**
 * 快速排序
 */
public class FastOrder {

    public static void sort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid  = arr[start];
        int low = start;
        int high = end;

        // 外层while的循环 只有在 low == high 的时候才会停止
        while(low < high){

            //从右往左 找到一个小于 mid 的数就退出循环，此时high为该数的下标
            while(low < high && arr[high] >= mid){
                high --;
            }

            // 从左往右 找一个大于 mid 的数就退出循环。此时low为该数的下标
            while(low < high && arr[low] <= mid){
                low ++;
            }

            // 交换
            if(low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        arr[start] = arr[low];
        arr[low] = mid;

        sort(arr, start, low-1);
        sort(arr, low+1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,13,14,15,16,17,18,12,10,9,8,7,6,5};
        sort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
