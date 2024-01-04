package com.cskaoyan.oop.access.one;

/*
        private: 只有在同一个类中才能访问
        默认权限(包访问权限): 只有在同包中才能访问到
        public: 相当于没有权限，在哪里都可以访问
 */
public class Student {

    // 私有访问权限
    private int privateField;

    // 默认访问权限
    double defaultField;

    // public访问权限
    public String publicField;


    public void testAccess() {
        // 访问private权限成员变量
        System.out.println(this.privateField);

        // 默认访问权限的成员
        System.out.println(this.defaultField);

        // 访问public
        System.out.println(this.publicField);

        Student student = new Student();
        System.out.println(student.privateField);
    }

}
