package com.cskaoyan.oop3.interfaces.basic;


/*
     从JDK8开始，接口中有两种方法可以具有方法体:
     1. 默认方法: 访问权限默认public
        主要是为了在修改接口之后，不影响之前已经实现了接口的所有类
     2. 静态方法: 类比于在类中工具方法
     3. 但是在实际开发中，我们在接口中，绝大部分场景下，只定义抽象方法 ——> 接口描述一个功能集合
 */
public class Demo4 {
    public static void main(String[] args) {

        InterfaceClass interfaceClass = new InterfaceClass();
        // 调用默认方法
        interfaceClass.defaultMethod();

        // 在其他类中访问接口的静态方法
        IJDK8Interface.staticMethod();

    }
}


interface IJDK8Interface {


    static void main(String[] arg) {
        System.out.println("hello interface main");
    }

    //void newMethod();

    // 抽象方法
    void absMethod();

    // 默认方法(从方法定义来看，只比普通方法多了一个default)
    default void defaultMethod() {
        System.out.println("hello, default method");
    }

    // 静态方法
    static void staticMethod() {
        System.out.println("hello, static method");
    }
}

class InterfaceClass implements IJDK8Interface {

    @Override
    public void absMethod() {
        // 方法实现

        // 调用父接口中定义的默认方法
        defaultMethod();


        // 调用父类的静态方法
        //staticMethod();

        // 只能以接口名. 调用父接口中定义的静态方法
        IJDK8Interface.staticMethod();

    }

    // 覆盖父类中的默认方法
    @Override
    public void defaultMethod() {
        System.out.println("son default");
    }
}


