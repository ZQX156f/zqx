package com.cskaoyan.basic.operator;

/*
 逻辑（logical）运算符指的是专门连接布尔类型变量、常量进行运算的运算符。
 当然逻辑运算表达式的结果也一定是boolean类型。


   ^ 异或运算符:  相同为false， 不同为true

   短路效果:
     1. && 和 & 运算过程有区别:  && 比较智能体现在短路效果
        && 在发现左边的操作数为false， 右边不计算直接得到 false的结果
        &  在发现左边的操作数为false，会计算右边的表达式，进行与运算

     2. || 和 | 运算过程有区别: || 比较智能，体现在短路效果
        || 在发现左边的操作数为true，不运算右边的表达式， true
        |  在发现左边的操作数为true，会不运算右边的表达式，做或运算得到结果


 */
public class Demo4 {

    public static void main(String[] args) {

        // & 与运算
        System.out.println( true & false);

        // |
        System.out.println(true | false);

        // !
        boolean b = true;
        System.out.println(!b);

        // ^
        boolean first = true;
        boolean seocnd = true;
        System.out.println(first ^ seocnd);


        int a = 1;
        int c = 5;
        boolean result = a > c && c++ > 0;
        //System.out.println(c);
        result = a > c & c++ > 0;
        //System.out.println(c);



        int e = 10;
        int f = 20;
        boolean compare = e < f || f++ > 0;
        System.out.println(f);
        compare = e < f | f++ > 0;
        System.out.println(f);


    }
}
