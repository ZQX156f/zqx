package com.cskaoyan.oop.block;

/*
        静态代码块: 被static修饰的，定义类中成员位置的代码块
           //成员位置
            static{
                // 局部位置
            }
       执行时机： 随着类加载而执行，又因为一个类最多只会在一个jvm中加载一次，静态代码块最多执行一次
       作用:  可以给静态变量赋初值
       注意：
        1. 静态代码块本身，也是一个静态上下文
        2. 静态代码块和静态成员变量的显示赋值语句，它们的执行顺序，取决于代码书写顺序
        3. 静态代码块也经常被用来测试类加载的顺序（重要）
 */
public class Demo3 {

    public static void main(String[] args) {
        //StaticBlock staticBlock1 = new StaticBlock();
        //StaticBlock staticBlock2 = new StaticBlock();

        System.out.println(StaticBlock.a);

        // 调用方法
        test(); // 替换成内存地址
    }


    public static void test() {

    }
}

class StaticBlock {

    int b;



    //成员位置
    static {

        // c是一个局部变量
        int c = 100;

        // 静态变量的初始化
        a = 200;

        // 局部位置
        System.out.println("static block run");

        // 静态代码块中不能访问非静态的成员
        //System.out.println(b);
    }

    static int a = 10;


}
