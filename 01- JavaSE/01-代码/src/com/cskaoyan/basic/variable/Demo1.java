package com.cskaoyan.basic.variable;

/*
      我们现阶段学习的都是局部变量, 局部：
      1. 方法体中
      2. 类中定义代码块
      3. 方法体中，定义的代码块

      简单理解 {}

      注意：class {} 不是代码块

      局部变量的特点除了需要定义在局部位置，就是它的使用需要经过以下两步：
            1. 声明局部变量    数据类型  变量名；
            2. 初始化局部变量  变量 = 值

 */
public class Demo1 {

    // 类体中的代码块
    {
        // 局部变量
       int c = 100;
    }

    public static void main(String[] args) {
        // 方法体中的局部变量
        int a = 1;

        // 代码块
        {
            int intValue = 90;
            System.out.println(intValue);

            // 定义同名变量（嵌套的作用域中不能定义同名变量）
            //int a = 100;
        }


        {
            // 没有嵌套关系的作用域中，可以定义同名变量
            int intValue = 999;
        }

        // 已经访问不到，出了intValue的作用域
        // System.out.println(intValue);


        // 生命变量
        double doubleValue;
        // 初始化局部变量
        doubleValue = 100.5;
    }
}
