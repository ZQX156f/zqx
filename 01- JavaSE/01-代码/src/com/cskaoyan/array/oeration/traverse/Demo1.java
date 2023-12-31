package com.cskaoyan.array.oeration.traverse;

import java.util.Arrays;

/*
     数组的遍历
 */
public class Demo1 {

    public static void main(String[] args) {

        int[] ints = new int[0];
//        ints[0] = 100;
//        ints[2] = 999;
        //traverseArray(ints);

        // JDK工具方法 Arrays.toString(数组)
        String string = Arrays.toString(ints);
        //System.out.println(string);

        // 自己实现
        String s = printArray(ints);
        //System.out.println(s);

        // 排序 Arrays.sort(数组)
        int[] a = {18, 100, 24, 1};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));


    }

    public static void traverseArray(int[] a) {

        // a表示的是指向一个数组的引用变量
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static String printArray(int[] arr) {
        String result = "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                result = result + arr[x] + "]";
            } else {
                result = result + arr[x] + ", ";
            }
        }
        return result;
    }
}
