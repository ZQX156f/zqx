package com.cskaoyan.oop.constructor;

/*

        这里我们不妨总结一下，学完构造器后，三种给成员变量赋值的方式：
        1. 默认初始化，具有默认值。
        2. 显式赋值，直接将值写在成员变量声明的后面。
        3. 构造器赋值。

通过下面的例子分析程序执行流程
 */
public class Demo2 {

    public static void main(String[] args) {

        Person person = new Person("zs", 18);

        System.out.println(person.age);
    }
}

class Person{
    String name;
    int age = 20;

    double height;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
