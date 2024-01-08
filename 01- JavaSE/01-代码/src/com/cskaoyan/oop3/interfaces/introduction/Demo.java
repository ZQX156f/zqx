package com.cskaoyan.oop3.interfaces.introduction;

/*
       在马戏团中，一些特殊猫，狗等动物，经过特殊训练之后，它们有一种特殊的行为: 直立行走

 */
public class Demo {
}

abstract class Animal {
    public abstract void shout();

    // 声明经过特殊训练的行为
}
class Cat extends Animal {

    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}
class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}

/*
      接口描述功能集合， 用于扩展已有类
 */
abstract interface SpecialSkill {
    public abstract void walk();
}

class SpecialDog extends Dog implements SpecialSkill {

    @Override
    public void walk() {
        System.out.println("dog walk");
    }
}

class SpecialCat extends Cat implements SpecialSkill {

    @Override
    public void walk() {
        System.out.println("cat walk");
    }
}


