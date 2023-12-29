package com.cskaoyan.method.basic;

import java.util.Scanner;

/*
      1. 两int数最大值
      2. 键盘录入两个值，求最大值。
      3.定义一个方法用于判断一个正整数的奇偶性，要求：
            1. 奇数方法返回false
            2. 偶数方法返回true
 */
public class EX {

    public static void main(String[] args) {
        // 接收调动
        int max = max(10, 20);
        //System.out.println(max);
        // 输出调用
        //System.out.println(max(10, 20));


        // 键盘录入两个值, 求大者
        //System.out.println(scannerInputMax());

        // 义一个方法用于判断一个正整数的奇偶性
        //System.out.println(isEven(99));

    }



    //  1. 两int数最大值
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    // 2. 键盘录入两个值，求最大值。
    public static int scannerInputMax() {

        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int j = scanner.nextInt();

        return i > j ? i : j;
    }

    //定义一个方法用于判断一个正整数的奇偶性
    public static boolean isEven(int a) {
        return a % 2 == 0 ? true : false;
    }


    public static double getArea(int r) {
        return Math.PI * r * r;
    }


}
