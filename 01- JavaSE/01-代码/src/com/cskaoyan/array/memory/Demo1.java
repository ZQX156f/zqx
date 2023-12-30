package com.cskaoyan.array.memory;


/*
     演示方法执行过程中的 栈内存的分配和回收
 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println("main 方法");
        test1();

        Object o = new Object();
    }

    public static void test1() {
        int a = 2;
        System.out.println("test1 方法");
        test2();
    }

    public static void test2() {
        int a = 1;
        System.out.println("test2 方法");
    }
}
