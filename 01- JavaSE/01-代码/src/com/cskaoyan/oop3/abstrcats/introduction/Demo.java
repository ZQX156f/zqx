package com.cskaoyan.oop3.abstrcats.introduction;

public class Demo {
}

abstract class Animal {
    public abstract void shout();
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
