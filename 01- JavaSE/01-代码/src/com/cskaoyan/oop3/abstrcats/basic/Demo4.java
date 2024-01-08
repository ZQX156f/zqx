package com.cskaoyan.oop3.abstrcats.basic;

/*
        abstract修饰方法时，该方法不能有修饰符：
        1. private
        2. static
        3. final

        一个抽象类中可以没有抽象方法，但是没有意义
 */
public class Demo4 {

    public static void main(String[] args) {

    }

    // abstract 与 private
//    private abstract void privateMethod() {
//
//    }

    // abstract 与 static
//    public static abstract void staticMethod() {
//
//    }

    // abstract 与 final
//    public abstract final void finalMethod() {
//
//    }
}

abstract class AbstractKey {
    public abstract void test();
}

// 一个抽象类中，可以不包含抽象方法
abstract class A {}
class B extends A {}
