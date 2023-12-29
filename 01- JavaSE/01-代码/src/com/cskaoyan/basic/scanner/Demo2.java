package com.cskaoyan.basic.scanner;

import java.io.PrintStream;
import java.util.Scanner;

/*
        使用Scanner的注意事项
 */
public class Demo2 {

    public static void main(String[] args) {

        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);

        // 读取键盘录入的数据
//        int firstInt = scanner.nextInt();
//        System.out.println("firtInt = " + firstInt);
//
//        // 读取第二哥哥数据
//        int secondInt = scanner.nextInt();
//        System.out.println("sencondInt = " + secondInt);


        // 当我们nextXxx(nextInt, nextDoulbe)和nextLine 一起使用的时候

//
//        // 先读取一个整数值
//        int i = scanner.nextInt();
//        System.out.println("i = " + i);
//
//        // 读取一个字符串
//        String s = scanner.nextLine();
//        System.out.println("s = " + s);


        // 将所有的数据，都当做字符串来端，需要什么数据，转化什么数据

//        String s = scanner.nextLine();
//        // 第一个读取的整数
//        int i = Integer.parseInt(s);
//        System.out.println("i = " + i);
//
//        // 第二个数据字符串
//        String s1 = scanner.nextLine();
//        System.out.println("s1 = " + s1);

        // 数据转化不是任何情况下都可以成功的
//        String a = "10 ";
//        // 字符串  ——> 整数
//        int intValue = Integer.parseInt(a);
//        System.out.println(intValue);


        // nextLine是否会读取空格

        //int i = scanner.nextInt();
        //System.out.println(i);

        String s = scanner.nextLine();
        System.out.println(s.length());

    }
}
