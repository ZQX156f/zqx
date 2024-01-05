package com.cskaoyan.oop2.extend.introduction.edition1;


/*
        1. 人类：有姓名属性，以及吃饭这个行为
        2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学两种行为
        3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
 */
public class Demo {
}

class Person {

    String name;


    public void eat() {
        System.out.println("吃饭");
    }

}

class Student {

    String name;

    int studentId;


    public void eat() {
        System.out.println("吃饭");
    }


    public void study() {
        System.out.println("学习");
    }
}

class Teacher {
    String name;

    int teacherId;


    public void eat() {
        System.out.println("吃饭");
    }

    public void teach() {
        System.out.println("教学");
    }
}
