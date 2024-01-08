package com.cskaoyan.oop3.interfaces.basic;


/*
    接口是一种表示对行为抽象的，不受Java单重继承限制的，用来作为功能扩展标准的一种引用数据类型

    [访问权限修饰符] interface 接口名{

    }

    注意事项：
    1. 接口的访问权限修饰符也只有两种：
        1). public
        2). 默认缺省的
    2. 命名规范: 建议以I开头
    3. 接口中可以定义抽象方法，和抽象类中定义抽象方法没有区别。
    4. 接口之间可以相互继承, 类可以"继承"接口(称之为类实现接口), 用implements关键字表示
        [访问权限修饰符] class 类名 extends 类名 implements 接口名 {}
    5. 在接口的实现中，可以称呼接口为"父接口"，接口的实现类为"子类"，
       它们仍然是父子关系。当然多态现象仍然能够发生。
    6. 接口不受单重继承限制，一个类可以在继承别的类的同时实现接口，而且可以实现多个接口。
 */
public class Demo1 {
}

interface FirstInterface {

    public abstract void first();
}

interface SecondInterface extends FirstInterface {
   public abstract void second();
}

// 接口的命名，建议以I开头
interface IPerson {
//    接口中只能定义抽象方法
//    public void test() {
//
//    }
}

class A extends Demo1 implements FirstInterface, SecondInterface {

    @Override
    public void first() {

    }

    @Override
    public void second() {

    }
}


