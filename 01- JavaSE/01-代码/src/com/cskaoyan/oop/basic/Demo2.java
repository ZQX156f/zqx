package com.cskaoyan.oop.basic;

/*
       从另外一个角度理解类: 数据类型的角度
       数据类型： 表示的是一组数据的集合，和基于该数据集合的一组合法操作。

       类本身就是我们开发者自定义的数据类型

       int short byte char
 */
public class Demo2 {

    public static void main(String[] args) {
        // 基本类型的变量
        int a = 1;

        // 定义一个对象
        Person person = new Person();

        person.name = "ww";
        person.age = 20;
        // 调用成员方法并传递参数
        person.sleep(8);

    }
}

class Person {

    String name;

    int age;

    public void eat() {
        System.out.println(name + "吃饭");
    }

    public void sleep(int hour) {
        System.out.println(name + "睡了" + hour + "小时");
    }


}
