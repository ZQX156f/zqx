package com.cskaoyan.oop3.link;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();

        // 链式调用
        //integers.stream().map().filter().map()


        // 我们自己实现一个链式调用
//        Student student = new Student();
//        Teacher teacher = student.getTeacher();
//        teacher.show();

        // 链式调用
        new Student().getTeacher().show().show().show();
    }
}

class Student{

    public Student getStudent(){
        return new Student();
    }

    public Teacher getTeacher(){
        return new Teacher();
    }
}

class Teacher{
    public Teacher show(){
        System.out.println("秀一波~~~");
        return this;
    }
}
