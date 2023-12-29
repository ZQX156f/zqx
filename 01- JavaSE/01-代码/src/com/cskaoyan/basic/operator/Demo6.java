package com.cskaoyan.basic.operator;

/*
        三目（ternary）运算符，也被称之为三元运算符，即指的是需要三个操作数的运算符。
        (条件表达式) ? 表达式1 : 表达式2;
 */
public class Demo6 {

    public static void main(String[] args) {
        int a = 1;
        int b = 999;

        // 两数取大
        int r = a > b ? a : b;
        System.out.println(r);

        // 三数取大
        int c = 100;
        int result = (a > b ? a : b) > c ? (a > b ? a : b) : c;

    }
}
