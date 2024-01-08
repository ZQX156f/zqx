package com.cskaoyan.oop3.abstrcats.basic;

/*
        抽象类的成员组成:
        1. 普通成员变量: 和普通类没有区别
        2. 普通成员方法: 可以定义普通成员方法， 主要是为了代码复用
        3. 抽象方法: 可以定义抽象方法, 主要是声明有这样的行为
        4. 构造方法: 可以定义
        5. 代码块:
 */
public class Demo2 {
}

abstract class AbstractComponent {

    // 普通成员变量
    int a;

    // 构造代码块
    {
        a = 10;
    }

    static {
        System.out.println("hello");
    }


    public AbstractComponent(int i) {
        this.a = i;
    }


    // 普通成员方法
    public int getA() {
        return a;
    }

    abstract void method();

}

class Son extends AbstractComponent {

    public Son(int i) {
        super(i);
    }

    @Override
    void method() {

    }
}
