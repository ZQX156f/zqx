package com.cskaoyan.array.memory;


/*
        - 静态初始化一个数组，输出数组名，元素取值，长度
        - 然后声明第二个数组，把第一个数组的地址赋值给第二个数组。
        - 输出第二个数组的数组名，元素取值，长度
        - 然后给第二个数组赋值，再次输出两个数组的名及元素

 */
public class EX2 {

    public static void main(String[] args) {

        // 静态初始化
        int[] a = {1, 2};

        System.out.println("----------1---------");
        System.out.println(a);
        System.out.println(a[0]);
        System.out.println(a[1]);

        // 声明第二个数组
        // 引用变量可以相互赋值(相同类型的引用变量)
        int[] b = a;

    }
}
