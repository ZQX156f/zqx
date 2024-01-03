package com.cskaoyan.oop.block;

public class Demo2 {

    public static void main(String[] args) {

        Student student = new Student();

        Student student3 = new Student();

        Student student1 = new Student(10);

        Student student2 = new Student(10, "zs");


        System.out.println(Student.count);

    }
}


class Student {

    int age;
    String name;

    static int count;

    // 利用构造代码块在每次创建对象的时候，统计对象的数量
    {
        count++;
    }


    public Student() {
        //count++;
    }

    public Student(int age) {
       // count++;
        this.age = age;
    }

    public Student(int age, String name) {
      //  count++;
        this.age = age;
        this.name = name;
    }
}