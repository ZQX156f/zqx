package com.cskaoyan.basic.select;

import java.util.Scanner;

/*
      Java中提供了**选择结构**，来帮助我们实现这种 "如果...就" 的逻辑。
       选择结构的具体实现有两种：
        1. if语句
        2. switch语句

        // 单分支
        if (condition){
	        // statement
        }

        // 双分支的if
        if(condition){
        // statement1
        }else{
        // statement2
        }

        // 多分支的if-else
        if(condition1){
            // statement1
        } else if (condition2){
            // statement2
        } .... else {
            // statement
        }
 */
public class Demo1 {

    public static void main(String[] args) {
        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);

        // 读取一个整数
        int i = scanner.nextInt();

        // 如果输入的是正数
//        if (i > 0) {
//            System.out.println("您输入了正数");
//        }

        // 如果输入了正数，输出您输入了正数，否则输出您输入了非正数
//        if (i > 0) {
//            System.out.println("您输入了正数");
//        } else {
//            System.out.println("您输入了非正数");
//        }

        // 双分支的if-else 和 三目运算很像
        // 两数求大
//        int a = 100;
//        int b = 200;
//
//        int c;
//        if (a > b) {
//            c = a;
//        } else {
//            c = b;
//        }
//        System.out.println(c);
//
//        c = a > b ? a : b;

        // 当我们用if-else在不同的条件下，只是做一个操作
        // 输出大者
//        if (a > b) {
//            System.out.println(a);
//        } else {
//            System.out.println(b);
//        }

        // 多分支 if - else

        if (i > 0) {
            System.out.println("您输入了正数");
        } else if (i < 0) {
            System.out.println("您输入了负数");
        } else {
            System.out.println("您输入了0");
        }





    }
}
