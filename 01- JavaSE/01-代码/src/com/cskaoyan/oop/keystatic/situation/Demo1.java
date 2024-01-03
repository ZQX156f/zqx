package com.cskaoyan.oop.keystatic.situation;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

/*

        创建一个学生类,  有2个属性: 姓名String name , 学号int id
        统计外部创建Student类对象的个数 假设给Student类的对象自动编号
        这个编号第一次创建对象是10001 随后每创建一个新对象就+1
 */
public class Demo1 {

    public static void main(String[] args) {

        Student first = new Student();
        System.out.println(first.id);
        Student second = new Student("zs");
        System.out.println(second.id);
        Student third = new Student();
        System.out.println(third.id);


        System.out.println(Student.count);
    }
}


class Student {


    String name;

    int id;

    static int count;

    public Student() {
        id = 1001 + count;
        count++;
    }

    public Student(String name) {
        id = 1001 + count;
        count++;
        this.name = name;
    }
}