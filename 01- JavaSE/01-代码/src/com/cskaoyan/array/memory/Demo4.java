package com.cskaoyan.array.memory;


/*
      通过输出语句，证明基本数据类型的数据和引用过类型的数据的区别
 */
public class Demo4 {

    public static void main(String[] args) {

        int a = 1;
        // 输出的是变量中的值
        System.out.println(a); // 1

        int[] array = {1, 2, 3};
        System.out.println(array); // [I@1b6d3586

    }
}
