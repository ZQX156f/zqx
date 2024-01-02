package com.cskaoyan.oop.load;

/*
       1. 一个类的类加载在一次程序运行过程中，最多只有一次。

        2. 多个引用指向同一个对象时，某个引用修改了对象的状态（成员变量的取值），再用其它引用访问会得到修改后的结果。

            注：这一点实际上和数组是一样的。

        3. 类加载IO流操作, 很耗费性能，所以JVM在进行类加载时是"懒加载"的, 迫不得已才加载.

         我们把一定会触发类加载的场景，称之为类加载的时机，目前已经学过的有：

             1. 创建该类对象
             2. 启动该类中的main方法


        三个对象的内存图，其中有两个引用指向同一个对象。(创建3个Teacher对象,并进行显式赋值)

 */
public class Demo1 {

    {

    }

    public static void main(String[] args) {
        // 第一个Teacher对象
        Teacher firstTeacher = new Teacher();
        System.out.println(firstTeacher.name);
        System.out.println(firstTeacher.age);
        System.out.println(firstTeacher.workId);

        firstTeacher.name = "zs";
        firstTeacher.age = 18;
        firstTeacher.workId = 1;
        System.out.println(firstTeacher.name);
        System.out.println(firstTeacher.age);
        System.out.println(firstTeacher.workId);

        // 创建第二个对象
        Teacher secondTeacher = new Teacher();
        secondTeacher.name = "lisi";
        secondTeacher.workId = 2;
        System.out.println(secondTeacher.name);
        System.out.println(secondTeacher.age);
        System.out.println(secondTeacher.workId);

        // 声明第三个对象
        Teacher thirdTeacher = secondTeacher;
        thirdTeacher.age = 999;
        System.out.println(secondTeacher.age);


        {
            int a = 1;
        }
        //System.out.println(a);

    }
}

class Teacher {

    // 姓名
    String name;

    // 年龄
    // 成员变量的显示赋值(初始化语句)
    int age = 100;
    //老师的工号
    int workId;


    public void teach() {
        System.out.println(name + "上课");
    }

}

