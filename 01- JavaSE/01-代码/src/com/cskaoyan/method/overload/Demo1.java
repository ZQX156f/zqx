package com.cskaoyan.method.overload;


/*
       Java是存在这种机制的，那就是Java的方法重载（overload）机制。
       方法重载允许一个类中，多个方法拥有相同的名字

       方法签名： 方法名 + 参数列表
 */
public class Demo1 {


    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        int result = add(a, b);
    }



    //计算两个int类型数据之和，并输出结果
    public static int add(int a, int b) {
        return a + b;
    }

    //计算两个double类型数据之和，并输出结果
    public static double add(double a, double b) {
        return a + b;
    }

    //计算两个long类型数据之和
    public static long add(long a, long b) {
        return a + b;
    }
}
