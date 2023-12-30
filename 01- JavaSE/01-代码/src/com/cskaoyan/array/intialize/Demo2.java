package com.cskaoyan.array.intialize;


/*
        动态初始化指的是：
        程序员只是指定数组的长度，数组中每个元素的初始值由系统（实际上是JVM）决定。

        和数组的声明写在一起，语法格式就是：
        数据类型[] 数组名 = new 数据类型[数组长度];
 */
public class Demo2 {

    public static void main(String[] args) {
        // 动态初始化
        int[] a = new int[3];


        //静态初始化和动态初始化叠加使用，是经典的错误错误
        //int[] array = new int[3] {1, 32, 45};

    }
}
