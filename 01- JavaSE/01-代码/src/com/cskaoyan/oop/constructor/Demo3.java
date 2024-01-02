package com.cskaoyan.oop.constructor;

public class Demo3{
    public static void main(String[] args){
        Student stu = new Student(18,"王冰冰");
    }
}
class Student {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Student(int age) {
        System.out.println("Student age");
        this.age = age;
    }

    public Student() {
    }

    public Student(int age, String name) {
        // 调用了1参构造方法
        this(age);
        System.out.println("Student age，name");
        this.name = name;
    }
}
