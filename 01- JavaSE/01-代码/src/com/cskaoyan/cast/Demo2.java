package com.cskaoyan.cast;

/*
        整数常量运算的特殊性：

 */
public class Demo2 {

    public static void main(String[] args) {
        // 不报错的原因: 编译器比较智能
        byte b = 1 + 2;
        int a = 1;
        // 报错的原因: 变量的值对于编译器不可知
        //byte b2 = a + 2;


        // 展示整数常量特殊性
        byte a1 = 100;
        short b1 = 30000;
        byte c1 = 1 + 120;

        // 编译器检查超出了范围
        //byte a2 = 128;
        //short b2 = 30000 + 10000;


        // 编译器不会对小数类型的常量做运算和判断
        //float f = 0.1;
        // 编译错误
        //float f2 = 0.1 + 0.2;
    }
}
