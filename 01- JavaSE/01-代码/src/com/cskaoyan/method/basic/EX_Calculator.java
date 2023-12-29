package com.cskaoyan.method.basic;

/*
        定义一个计算器（Calculator）它的功能有：
        1. 加，减，乘，除
        2. 求平方
        3. 求a的n次方
 */
public class EX_Calculator {

    public static void main(String[] args) {
        int add = add(10, 20);
        System.out.println(add);
    }

    // 加法运算
    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }


    public static int square(int a) {
        return a * a;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }


}
