package com.cskaoyan.oop3.interfaces.basic;


/*
     从JDK8开始，接口中有两种方法可以具有方法体:
     1. 默认方法: 访问权限默认public
     2. 静态方法:

 */
public class Demo4 {
    public static void main(String[] args) {

    }
}


interface IJDK8Interface {

//    void newMethod();

    // 抽象方法
    void absMethod();

    // 默认方法(从方法定义来看，只比普通方法多了一个default)
    default void defaultMethod() {
        System.out.println("hello, default method");
    }

    // 静态方法
//    static void staticMethod() {
//        System.out.println("hello, static method");
//    }
}

class InterfaceClass implements IJDK8Interface {

    @Override
    public void absMethod() {
        // 方法实现
    }
}
