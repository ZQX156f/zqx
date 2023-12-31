package com.cskaoyan.array.oeration.reverse;

/*
      数组逆序：
 */
public class Demo1 {

    public static void main(String[] args) {


    }
    
    
    public static void  reverse(int[] a) {
        // 数组逆序
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            a[i] = a[a.length - 1 -i] ;
            a[a.length - 1 -i] = tmp;
        }
        
    }
}
