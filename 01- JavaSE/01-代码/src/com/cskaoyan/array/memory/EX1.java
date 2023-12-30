package com.cskaoyan.array.memory;


/*
        分别静态、动态初始化两个数组，分别输出数组名及元素。
        然后分别给数组中的元素赋值，再次分别输出数组名及元素。
 */
public class EX1 {
    public static void main(String[] args) {

        // 静态初始化
        int[] a = {10, 20 ,30};

        // 动态初始化
        int[] b = new int[3];

        System.out.println("--------1---------");
        System.out.println(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println("----------2--------");
        System.out.println(b);
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);

        // 修改a数组的值
        a[0] = 999;
        // 修改b数组的值
        b[2] = 1000;

        System.out.println("--------1---------");
        System.out.println(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println("----------2--------");
        System.out.println(b);
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);


    }
}
