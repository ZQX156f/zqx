package com.cskaoyan.oop.access.one;

public class Test {
    public static void main(String[] args) {

        Student student = new Student();

        // 访问private成员  访问不到
        //System.out.println(student.privateField);

        // 访问默认访问权限的成员
        System.out.println(student.defaultField);

        // 访问public
        System.out.println(student.publicField);
    }
}
