package com.cskaoyan.string;

/*
     1. "" 每一个字符串字面值常量，都是一个字符串对象
     2. 字符串字面值常量，它只会在jvm中存储一份
     3. "存储" 字符串常量池

 */
public class Demo4 {

    public static void main(String[] args) {
        String s = "hello";
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(s == s1);
        System.out.println(s1 == s2);
    }
}
