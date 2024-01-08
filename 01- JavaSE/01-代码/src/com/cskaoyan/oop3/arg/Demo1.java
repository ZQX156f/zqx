package com.cskaoyan.oop3.arg;

/*
方法传值
方法的形参在方法调用传入实参时，不一定要求数据类型完全一致。
基本类型：对于基本数据类型的方法形参，存在自动类型提升。
引用类型：对于引用数据类型的方法传参，存在自动向上转型。
  1. 形参如果写一个普通类：调用方法时需要传入的是该类的对象或者该类的子类对象
  2. 形参如果写一个抽象类：调用方法时需要传入的是该抽象类的子类对象
  3. 形参如果写一个接口：调用方法时需要传入的是该接口的子类对象

方法的返回值
方法的返回值类型，和在方法体中返回具体值（对象）时，不一定要求数据类型完全一致。
基本类型：方法体中，返回一个具体的值不要求和返回值类型完全一致，存在自动类型提升。
引用类型： 在方法体中，返回一个对象时不要求就是返回值类型的对象，存在自动向上转型。
  1. 返回值类型如果写一个普通类：可以返回该类的对象或者该类的子类对象
  2. 返回值类型如果写一个抽象类：返回该抽象类的子类对象。
  3. 返回值类型如果写一个接口：返回该接口的子类对象。
 */
public class Demo1 {


    public static void main(String[] args) {
        // 测试方法参数
        testArg();
    }

    public static int  basicReturnValue() {
        byte b = 1;
        return b;
    }


    // 测试返回值
    public static Father returnNomalObj () {

        // 返回父类对象
        //return new Father();

        // 返回子类对象
        return new Son();
    }

    public static AbstractFather returnAbsObj() {
        // 返回抽象类的子类对象
        return new AbstractSon();
    }

    public static IInterface returnInterfaceObj() {

        //返回接口子类对象
        return new InterfaceSon();
    }

    /*
          ctrl + alt + m
     */
    private static void testArg() {
        byte b = 1;
        // 基本数据类型参数
        method(b);

        Son son = new Son();
        // 普通对象
        normalObjMethod(son);

        // 抽象类对象 传递抽象类子类对象
        AbstractSon abstractSon = new AbstractSon();
        abstractObjMethod(abstractSon);


        // 接口对象  传递接口子类对象
        InterfaceSon interfaceSon = new InterfaceSon();
        interfaceObjMethod(interfaceSon);
    }


    // 演示基本数据类型参数传递时的隐式类型转化
    public static void method(int a) {

    }

    public static void normalObjMethod(Father father) {

    }

    public static void abstractObjMethod(AbstractFather abstractFather) {

    }

    public static void interfaceObjMethod(IInterface iInterface) {

    }
}

class Father {}
class Son extends Father {}

abstract class AbstractFather {
    public abstract void test();
}

class AbstractSon extends AbstractFather {

    @Override
    public void test() {

    }
}

interface IInterface {
    void test();
}

class InterfaceSon implements IInterface {

    @Override
    public void test() {

    }
}
