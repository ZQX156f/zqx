package com.cskaoyan.basic.scanner;

import java.util.Scanner;

/*

        模拟登陆功能

        用户名(String):admin
        密码(String): 123456

        使用scanner进行输入, 匹配成功提示登陆成功, 否则登陆失败

 */
public class EX1 {

    public static void main(String[] args) {

        // alt + enter
        // 创建对象
        Scanner scanner = new Scanner(System.in);

        // 读取用户名
//        String userName = scanner.nextLine();
//
//        // 读取用户密码
//        String password = scanner.nextLine();
//
//        if ("admin".equals(userName) && "123456".equals(password)) {
//            System.out.println("登录成功");
//        } else {
//            System.out.println("登录失败");
//        }


        // 字符串比较不能使用==
        String s = "hello";
        String s1 = scanner.nextLine();
        System.out.println(s == s1);

    }
}
