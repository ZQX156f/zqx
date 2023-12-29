package com.cskaoyan.basic.loop;

/*
     for 循环
     for(初始化语句 ; 条件判断语句; 循环控制语句) {
        // 循环体语句
    }

    初始化语句;
        for( ; 条件判断语句(布尔表达式); 循环控制语句) {
          // 循环体语句
        }
 */
public class Demo1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello, world");
        }
        // i的作用域仅限于循环体
        //System.out.println(i);


        int j = 0;
        for (; j < 10; j++) {
            System.out.println("hello, world");
        }
        System.out.println(j);

    }
}
