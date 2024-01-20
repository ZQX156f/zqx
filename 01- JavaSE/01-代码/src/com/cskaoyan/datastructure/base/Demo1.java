package com.cskaoyan.datastructure.base;


/*
        1. Java程序运行，需要处理内存数据的能力
        2. 但是，在处理数据之前，我们得现在内存中存储数据
           1) 字符串数组，很麻烦，扩容，维护数组信息
           2) 对象方式  数据 类定义严重耦合
 */
public class Demo1 {

    public static void main(String[] args) {

        // 1.存储字符串
        // 数组局限性: 数组创建之后，其长度不可修改
        String[] array = new String[10];
        // 扩容
        array = new String[100];
        // 其他数据的维护


        // 2. 对象的方式来存储(代码和数据 严重耦合)
        Strings strings = new Strings();
        //strings.s1 = ;



    }
}

class Strings {

    String s1;

    String s2;

    //。。。
    String sn;


}
