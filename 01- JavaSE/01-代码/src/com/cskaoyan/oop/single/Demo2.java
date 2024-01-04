package com.cskaoyan.oop.single;

import sun.security.jgss.wrapper.GSSCredElement;

public class Demo2 {

    public static void main(String[] args) {
        Singleton2 first = Singleton2.getInstance();

        Singleton2 second = Singleton2.getInstance();

        System.out.println(first == second);

    }
}
 class Singleton2 {

    // 提供一个自身类型的静态成员变量
    private static Singleton2 instance = new Singleton2();

    // 构造器私有
    private Singleton2() {
    }

    //提供一个静态的方法 , 来返回唯一的这个对象
    public static Singleton2 getInstance() {

        // 返回唯一的这个对象
        return instance;
    }

}
