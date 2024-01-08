package com.cskaoyan.oop3.interfaces.basic;

/*
        接口的声明特点
            1. 接口能不能创建对象?
            2. 接口能不能用final修饰?

       成员特点
        1). 成员变量: 只能是静态常量 默认的修饰符 public static final
        2). 成员方法: 不能定义普通成员方法 public abstract
        3). 构造方法，构造代码块，静态代码块不能定义

 */
public class Demo2 {

    public static void main(String[] args) {

        // 无法直接创建接口对象
        //InterfaceCharacter interfaceCharacter = new InterfaceCharacter();

        // "成员变量" static
        System.out.println(InterfaceCharacter.i);

        // "成员变量" final
        //InterfaceCharacter.i = 100;
    }
}

interface InterfaceCharacter {

//    接口中不能定义构造和静态和代码块
//    {
//
//    }
//
//    static {
//
//    }
    // 在接口中定义的成员变量，本质 static final 自定义常量
    int i = 10;
//    接口中不能定义构造方法
//    public InterfaceCharacter() {
//
//    }

    public abstract void test();

//    不能定义普通成员方法
//    public void test() {
//
//    }
}
