package com.cskaoyan.method.overload;

/*
        使用方法重载，控制台输出各种数据类型。
 */
public class EX {

    public static void main(String[] args) {

    }


    public static void print(byte b) {
        System.out.println();
    }

    public static void print(short s) {
        System.out.println(s);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(long l) {
        System.out.println(l);
    }

    public static void print(char c) {
        System.out.println(c);
    }

    public static void print(boolean b) {
        System.out.println(b);
    }

    public static void print(float f) {
        System.out.println(f);
    }

    public static void print(double  d) {
        System.out.println(d);
    }


}
