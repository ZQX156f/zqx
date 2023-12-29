package com.cskaoyan.basic.operator;

/*
        赋值（assignment）运算符指为变量指定新值完成赋值作用的运算符，
        赋值运算符需要连接两个操作数，是典型的二元运算符。赋值运算符可以分为两类：
        1. 基本的赋值运算符，即" = "等号。
        2. 基于等号扩展而来的扩展赋值运算符，比如：" += "，" -= "，" *=  "等。
 */
public class Demo2 {

    public static void main(String[] args) {

        int a = 1;
        int b = 2;

        // +=
        a += b;
        //System.out.println(a);

        // 复合赋值运算中，隐含了强制类型转化
        short s1 = 1;
        s1 += 1;
        System.out.println(s1);
    }
}
