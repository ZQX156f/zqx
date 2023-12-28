package com.cskaoyan.cast;

/*
        自动类型转化:
        1.  byte、short、char、int任何数据类型与long进行计算，一律自动转换为long进行计算，结果是long
        2.  byte、short、char、int、long任何数据类型与float进行计算，一律自动转换为float进行计算，结果是float
        3.  byte、short、char、int、long、float任何数据类型与double进行计算，一律自动转换为double进行计算，结果是double
        4. byte、short、char之间不互相转换，一旦发生运算，一律自动转换为int进行运算，结果是int
        5. byte、short、char任何数据类型与int进行计算，一律自动转换为int进行计算，结果是int


        // 做强转要慎重考虑再进行
            目标数据类型 变量名 = (目标数据类型)(被转换变量的变量名);
         大  ——> 小


 */
public class Demo1 {

    public static void main(String[] args) {

        byte byteValue = 10;
        short shortValue = 20;
        char charValue = 'c';
        int intValue =900;
        long longValue = 9;
        float floatValue = 0.9f;
        double doubleValue = 99.9;

        // byte、short、char、int任何数据类型与long进行计算
        long longReult = byteValue + shortValue + charValue + intValue + longValue;

        //byte、short、char、int、long任何数据类型与float进行计算
        float floatResult = byteValue + shortValue + charValue + intValue + longValue + floatValue;

        //byte、short、char、int、long、float任何数据类型与double进行计算
        // ctrl + alt + v
        double doubleResult = byteValue + shortValue + charValue + intValue + longValue + floatValue + doubleValue;

        //byte、short、char之间不互相转换，一旦发生运算，一律自动转换为int进行运算，结果是int
        int intResult = byteValue + shortValue + charValue;

        // 强制类型转化
        int a = 1111;
        byte b = (byte)a;
        System.out.println(b);
    }
}
