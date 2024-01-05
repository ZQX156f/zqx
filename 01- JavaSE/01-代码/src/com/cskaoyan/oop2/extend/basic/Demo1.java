package com.cskaoyan.oop2.extend.basic;


/*

      继承语法:
         [访问权限修饰符] class 类名 extends 被继承的类/已经存在的某个类{}

     注意事项:
       1. 这个继承了一个已存在类的类，称之为子类。被继承的类称之为父类。

        2. 使用继承extends(扩展)关键字后，子类就获取到了父类的所有成员（成员变量和成员方法）.严格来说，继承只考虑对象相关成员的继承，静态成员我们先暂时不考虑。

        3. 子类在继承父类的同时，还可以自己定义新的成员，这叫做子类在父类的基础上进行扩展（所以子类往往比父类的功能更加强大，青出于蓝而胜于蓝。）

        4. 子类不能继承父类没有的成员。
 */
public class Demo1 {

    public static void main(String[] args) {
        // 用一个父类类型的引用变量  指向 一个自类类型的对象
        Teacher teacher = new Teacher();
        //
        Person father = teacher;


        // 是否可以用一个子类类型的引用  指向父类类型的对象?
        //Teacher teacher = new Person();


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
