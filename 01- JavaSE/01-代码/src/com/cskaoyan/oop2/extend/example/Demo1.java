package com.cskaoyan.oop2.extend.example;


/*

    练习：
        在一款游戏中，我们设计了三种类型的鸭子，这些鸭子有一些共同的属性，也有共同的行为，比如都可以叫，都会游泳等。
        编写程序，描述这些鸭子。

        后来，需求更改了，这些鸭子不能游泳了，但是都会飞，怎么改呢？

        再后来，需求又改了，新增了一种鸭子，但这个鸭子不会飞，又怎么办呢？
 */
public class Demo1 {

    public static void main(String[] args) {
        FirstTypeDuck firstTypeDuck = new FirstTypeDuck();
        firstTypeDuck.fly();

        SecondTypeDuck secondTypeDuck = new SecondTypeDuck();
        secondTypeDuck.fly();

        ModelDuck modelDuck = new ModelDuck();
        modelDuck.fly();
    }




}

// 利用继承，让有所的鸭子具有相同的行为
class BaseDuck {

    public void shot() {
        System.out.println("嘎嘎嘎");
    }

//    public void swim() {
//        System.out.println("游泳");
//    }

    public void fly() {
        System.out.println("飞");
    }
}

class FirstTypeDuck extends BaseDuck {


}

class SecondTypeDuck extends BaseDuck {


}

class ThirdTypeDuck extends BaseDuck{


}

class ModelDuck extends BaseDuck {


    // 在子类中修改父类的fly方法的实现，让模型鸭不飞
    // 通过方法覆盖来实现
    public void fly() {
    }
}
