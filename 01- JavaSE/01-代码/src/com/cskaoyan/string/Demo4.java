package com.cskaoyan.string;

/*
     1. "" 每一个字符串字面值常量，都是一个字符串对象
     2. 字符串字面值常量，它只会在jvm中存储一份
     3. "存储" 字符串常量池


     两种方式
        直接赋值 String s = "abc"
        构造方法 String s = new String("abc")

 */
public class Demo4 {

    public static void main(String[] args) {
        // 引出字符串常量池
//        String s = "hello";
//        String s1 = "hello";
//        String s2 = "hello";
//
//        System.out.println(s == s1);
//        System.out.println(s1 == s2);

        // 两种不同的创建字符串对象的方式的区别
        String s = "abc";
        String ss = new String("abc");


    }
}
