package com.cskaoyan.oop.block;

/*
        静态代码块: 被static修饰的，定义类中成员位置的代码块
           //成员位置
            static{
                // 局部位置
            }
       执行时机： 随着类加载而执行
 */
public class Demo3 {

    public static void main(String[] args) {
        StaticBlock staticBlock1 = new StaticBlock();
        StaticBlock staticBlock2 = new StaticBlock();
    }
}

class StaticBlock {

    int b;

    static int a;

    //成员位置
    static {

        // c是一个局部变量
        int c = 100;

        // 静态变量的初始化
        a = 10;

        // 局部位置
        System.out.println("static block run");

        // 静态代码块中不能访问非静态的成员
        //System.out.println(b);
    }


}
