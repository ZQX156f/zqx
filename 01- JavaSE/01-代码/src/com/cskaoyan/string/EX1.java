package com.cskaoyan.string;

/*
- 当参与字符串拼接对的2个字符串,只要有1个引用变量的形式出现时,则会在堆上创建新的字符串对象.
    - 原因是因为参与了运算,无法在编译期确定其值,就不能在编译时期加入常量池
- 只有参与字符串拼接的2个字符串都是字面值常量的时候
  - 如果常量池中已有该字符串对象的引用,则返回常量池中的引用
  - 如果常量池中没有,则在堆上创建,并把引用放入常量池
 */
public class EX1 {

    public static void main(String[] args) {

//        String s1 = new String("hello");
//        String s2 = new String("hello");
//        System.out.println(s1 == s2); // false
//        System.out.println(s1.equals(s2)); // true
//
//        String s3 = new String("hello");
//        String s4 = "hello";
//        System.out.println(s3 == s4); // false
//        System.out.println(s3.equals(s4)); //true
//
//        String s5 = "hello";
//        String s6 = "hello";
//        System.out.println(s5 == s6); //true
//        System.out.println(s5.equals(s6)); //true


        String s1 = "Hello";
        String s2 = "Hello";
        // 编译器直接计算  "hello"
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);//  true
        System.out.println(s1 == s4);// false
        System.out.println(s1 == s9);// false
        System.out.println(s4 == s5);// false

    }
}
