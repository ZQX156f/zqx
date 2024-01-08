package com.cskaoyan.object;


/*
        Object类，我们虽然我们没有详细了解，但我们已经：Object类是所有类继承层次的祖先类，
        Java中所有类（包括数组）都直接或者间接的继承自该类，都实现了该类的方法。
 */
public class Demo1 {

    public static void main(String[] args) {
        A a = new A();
        a.hashCode();
        a.toString();
        a.getClass();

        B b = new B();
        b.hashCode();
        b.toString();
        b.getClass();
    }
}

class A {}

class B extends A {}
