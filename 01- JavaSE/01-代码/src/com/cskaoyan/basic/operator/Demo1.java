package com.cskaoyan.operator;
/*
     算术运算符:
       1. +: 1) +加法运算符  2) 字符串的拼接  3) 表示正号
       2. %： 取模运算符
       3. /: 如果是两整数相除，结果仍然是一个整数(省略小数部分)
       4. ++， --, 可以放在变量之前，可以放在变量之后
         1） 独立存在的情况, ++/-- 在前或者在后没有任何影响
         2） - 自增自减符号在变量前面，变量先自增自减，再参与后续运算或者赋值
            - 自增自减符号在变量后面，变量先参与运算或者赋值，再自增自减。


 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        String str = "hello";

        // 加法运算
        int addResult = a + b;
        // 字符串拼接  一旦两个操作数中，有一个是字符串，发生字符串的拼接
        // 得到一个新的拼接之后的字符串
        // "hello" + 10 等价于 hello10
        System.out.println(str + a);

        // %： 取模运算符
        System.out.println( a % 3);

        int c = 4;
        System.out.println(1.0 * a / c);

        // ++, -- 独立存在，不参与其他运算
        int a1 = 10;
        a1--;
        System.out.println(a1);

        a1 = 10;
        --a1;
        System.out.println(a1);

        int b1 = 100;
        b1++;
        System.out.println(b1);

        b1 = 100;
        ++b1;
        System.out.println(b1);


        // 参与运算
        int a3 = 100;
        int b3 = 900;
        int incrResult = a3++ + b3;
        System.out.println(incrResult);

        a3 = 100;
        incrResult = ++a3 + b3;
        System.out.println(incrResult);

        int x = 4;
        //       4  +   6  +   6*10
        int y = (x++) + (++x) + (x*10);
        System.out.println(y);

        int three;
        // 先赋值在使用
        three = 100;
        System.out.println(three);
    }
}
