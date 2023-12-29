package com.cskaoyan.basic.operator;



/*
        位运算符: 位运算符针对的是，二进制的位，位运算符的运算效率高
        1. &
        2. |
        3. ^:
          a: 任何数和它自己运算的结果是0
          b: 任何数和0异或结果它自己
        4. <<
        5. >>
        求a的b次幂
        Math.pow(double a, double b)
 */
public class Demo5 {
    public static void main(String[] args) {

        // &
        // 00000000 00000000 00000000 00000001
        int a = 1;
        // 00000000 00000000 00000000 00000011
        int b = 3;
        // 数值型的操作数，表现的就是位运算符的运算特征
        System.out.println(a & b);

        //|
        System.out.println(a | b);

        // ^
        System.out.println( a ^ b);
        System.out.println(a ^ a);
        System.out.println(a ^ 0);

        // <<
        System.out.println( a << 1);

        // >>
        System.out.println( a >> 1);

        // 求幂次
        double pow = Math.pow(2, 5);
        System.out.println(pow);

        System.out.println(2 << 4);

    }
}
