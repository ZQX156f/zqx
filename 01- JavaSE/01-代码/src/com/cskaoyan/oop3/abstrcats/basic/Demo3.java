package com.cskaoyan.oop3.abstrcats.basic;


/*
        抽象类的子类:
        1. 普通类:  子类必须覆盖父类中的每一个抽象方法，增加方法体
        2. 抽象类:  子类未完全实现父类的每一个抽象方法
 */
public class Demo3 {
}

abstract class AbstractFather {

    public abstract void  first();

    public abstract void second();
}

// 抽象类的子类是具体类
class FirstTypeAbstractSon extends AbstractFather {

    @Override
    public void first() {

    }

    @Override
    public void second() {

    }
}


// 抽象类的子类是抽象类
abstract class SecondTypeAbstractSon extends AbstractFather {

    @Override
    public void first() {

    }
}

