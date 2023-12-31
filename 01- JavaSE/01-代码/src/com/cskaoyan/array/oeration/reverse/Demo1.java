package com.cskaoyan.array.oeration.reverse;

import java.util.Arrays;

/*
      数组逆序：
 */
public class Demo1 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        int[] ints = reverse2(array);
        // 比较的是引用变脸的值即地址
        System.out.println(array == ints);
        //System.out.println(Arrays.toString(array));

    }
    
    
    public static void  reverse(int[] a) {
        // 数组逆序
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 -i] ;
            a[a.length - 1 -i] = tmp;
        }
        
    }

    // 方式2：定义2个标记
    public static int[] reverse2(int[] arr) {
        for(int start=0,end=arr.length-1; start<=end; start++,end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        return arr;
    }
}
