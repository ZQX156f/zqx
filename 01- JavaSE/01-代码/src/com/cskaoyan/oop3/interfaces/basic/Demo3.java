package com.cskaoyan.oop3.interfaces.basic;


/*
        接口的子类可以是什么？
        1. 普通类实现接口，必须实现所有的抽象方法。
        2. 抽象类实现接口，按需实现抽象方法。
        3. 接口可以继承一个接口，并且接口在继承接口后，可以重写父接口中的抽象方法和默认方法。
 */
public class Demo3 {
}

interface IFirstInterface {

    void first();
}

interface ISecondInterface {
    void second();
}

// 普通类
class FirstClass implements IFirstInterface {

    @Override
    public void first() {

    }
}

// 抽象类
abstract class SecondClass implements IFirstInterface,ISecondInterface {

    @Override
    public void first() {

    }
}

// 子接口
interface IThirdInterface extends IFirstInterface, ISecondInterface {

}

class Son implements IThirdInterface {

    @Override
    public void first() {

    }

    @Override
    public void second() {

    }
}
