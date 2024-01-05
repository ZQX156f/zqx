package com.cskaoyan.oop2.extend.introduction.edition2;


/*

        1. 人类：有姓名属性，以及吃饭这个行为
        2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学两种行为
        3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为

 */
public class Demo {

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
        student.eat();

        // 访问子类自己定义成员
        System.out.println(student.studentId);
        student.study();

    }
}

class Person {

    String name;


    public void eat() {
        System.out.println("吃饭");
    }

}

class Student extends Person {

    int studentId;

    public void study() {
        System.out.println("学习");
    }

}

class Teacher extends Person {
    int teacherId;


    public void teach() {
        System.out.println("教学");
    }
}
