package com.cskaoyan.string;


import java.util.Scanner;

/*
      String的特征: 不可变

 */
public class Demo2 {

    public static void main(String[] args) {

        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);
        // 键盘接收nextLine   -- > s
        String s = scanner.nextLine();
        // temp 指向
        String temp = s;
        // 更改s内容
        temp += "aaa";
        // 打印
        System.out.println("temp = " + temp);
        System.out.println(temp == s);
    }
}
