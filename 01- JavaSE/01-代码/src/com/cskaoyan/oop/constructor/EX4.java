package com.cskaoyan.oop.constructor;

public class EX4 {

    public static void main(String[] args) {
        Stu s = new Stu(18, "长风");
        System.out.println(s.age);
        System.out.println(s.name);
        System.out.println(s.var);
        System.out.println(s.cat.price);
    }
}

class Stu {
    int age = 10;
    String name = "张三";
    double var = 20;

    Cat cat = new Cat(1000);
    Cat c2;

    public Stu(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Stu() {
    }

    public Stu(int age, String name) {
        // 先调用一参构造方法
        this(age);
        System.out.println("Student age,name");
        this.name = name;
    }


}

class Cat {
    double price;

    public Cat() {
    }

    public Cat(double price) {
        System.out.println("Cat price");
        this.price = price;
    }
}
