package com.cskaoyan.basic.scanner;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        // 第二步创建Scanner对象
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个整数");
        // 读取键盘录入的数据  阻塞等待
        //int x = sc.nextInt();
        //System.out.println(x);

        // 读取小数
        //double v = sc.nextDouble();
        //System.out.println(v);

        // 读取字符串
        String s = sc.nextLine();
        System.out.println(s);
    }
}
