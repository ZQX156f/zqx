package com.cskaoyan.oop2.extend.init.introduction;

public class Demo1 {

    public static void main(String[] args) {

        Star star = new Star();
    }
}

class Person {

    String name;

    public void eat() {
        System.out.println("吃饭");
    }
}
class Star extends Person {

    String stageName;


    public void sing() {
        System.out.println("唱歌");
    }

}
