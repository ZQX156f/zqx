package com.cskaoyan.oop.access.another;

import com.cskaoyan.oop.access.one.Student;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();

        //访问私有成员 访问不到
        //System.out.println(student.privateField);


        // 访问默认权限的成员
        //System.out.println(student.defaultField);

        // 访问public
        System.out.println(student.publicField);
    }
}
