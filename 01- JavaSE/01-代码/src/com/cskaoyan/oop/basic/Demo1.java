package com.cskaoyan.oop.basic;

/*
        类定义：
         1. 整个类的生命
         2. 类中成员的定义
         1). 成员变量: 描述对象的共有属性
            定义在类体中，方法外的变量，就称之为成员变量

         2). 成员方法: 描述对象的共有行为
         1. 成员方法和我们之前使用的方法不一样，必须没有static修饰！！
         2. 访问权限修饰符我们还未学习，这里先默认是
         3. 其它诸如形参列表，方法体，方法名等结构和之前讲的方法一样。

         创建对象的语法:
           类名 对象名 = new 类名();

         对象的访问:
         1. 直接输出对象名
            和数组直接输出数组名是一样，默认情况下，直接打印对象名得到的是：
            -  该类的全限定类名 + "@" + 十六进制的地址值
            -  可以通过==进行地址值的比较

         2. 访问对象的属性值
            对象名.成员变量 可以赋值，可以读取该值;

         3. 访问对象的行为
            对象名.成员方法名(实参);
        注意事项
        1. 一个Java文件中的多个class是同包（文件夹）关系。
        2. 一个类当中，成员变量，而后再写成员方法。
        3. 类中没有的属性和行为，对象是不可能有的，类是模板，模板中有才能体现在对象中。
        4. 使用new关键字就会创建新的对象，两条new语句创建的对象是完全独立的。
        5. 成员变量，在类的全局生效，不像局部变量仅在作用域内生效！成员变量，在整个类体中生效，在整个类中的成员方法中都可以访问它！
 */
public class Demo1 {

    public static void main(String[] args) {
        // Student student 声明一个对象，定义一个指向堆上对象的引用变量
        Student student = new Student();
        student.age = 18;
        student.name = "zs";

        // 访问对对象
        //xxx@1b6d3586
        //System.out.println(student);

        // 访问对象的属性值
        //System.out.println(student.age);

        // 访问对象的name属性值
        //System.out.println(student.name);

        // 对象的行为
        //student.study(); //zs好好学习，天天向上

        // 创建第二个对象
        Student secondStudent = new Student();
        secondStudent.age = 100;
        secondStudent.name = "lisi";
        // 访问第二个对象的行为
        secondStudent.study(secondStudent); //lisi好好学习，天天向上

    }
}


class Student {

    // 姓名
    static String name;


    // 年龄
    int age;

    // 成员方法，描述行为
    public void study(Student secondStudent) {
        System.out.println(name + "好好学习，天天向上");
    }
}
