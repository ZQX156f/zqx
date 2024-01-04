package com.cskaoyan.work;

public class DemoObjectArray {

    public static void main(String[] args) {

        // 创建一个对象数组
        Student[] students = new Student[5];

        // 手动给数组的存储单元赋值
        Student student = new Student();
        students[0] = student;

        // 直接将new表达式的结果,赋值给对象数组的一个存储单元
        students[1] = new Student();
        System.out.println(students[0].age);
    }
}

class Student {

    int age;

    double java;

}
