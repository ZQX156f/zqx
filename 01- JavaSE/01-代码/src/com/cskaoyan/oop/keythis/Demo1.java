package com.cskaoyan.oop.keythis;

/*
        引出This

        Java类中的每个成员方法的形参列表中都隐含了一个传参（隐式传参），传入的是当前对象，用this关键字指向!
        (为什么类中的所有成员方法都可以访问到成员变量---->就是因为this的存在)

            1. this是一个引用，这个引用指向当前对象。

            2. 何为当前对象？

         成员方法总会需要一个对象，使用对象名点来调用该成员方法，这个调用该成员方法的对象，就是当前对象！
         Student stu = new Student();
        stu.study();
        stu.sleep();

        比如stu对象就是study()和sleep()方法的当前对象
 */
public class Demo1 {

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.color);
        System.out.println(car.speed);

        // 调用无参run方法
        //car.run();

        // 调用有参的run方法
        // 在那个对象上，调用方法，在方法执行时this就表示哪个对象
        car.run(999); // 黑色的车在高速公路上以120.0公里每小时疾驰!


        Car secondCar = new Car();
        secondCar.color = "红色";
        secondCar.speed = 777;
        secondCar.run(800); //红色的车在高速公路上以777.0公里每小时疾驰!

        // 成员变量，成员方法，只能以对象名.
    }

}

class Car{
    // 定义成员变量
    String color = "黑色";

    double speed = 120.0;

    // 定义成员方法
    public void run() {
        System.out.println(color + "的车在高速公路上以" + speed + "公里每小时疾驰!");
    }

    // 定义成员方法
    public void run(double speed){
        // 利用this关键字访问成员和成员方法
        System.out.println(this.color);
        // 当前对象上调用成员方法
        this.run();


        // 不要这样调用，这样的调用，就变成了没有递归出口的递归
        //this.run(speed);

        System.out.println(color + "的车在高速公路上以" + this.speed + "公里每小时疾驰!");
    }
}
