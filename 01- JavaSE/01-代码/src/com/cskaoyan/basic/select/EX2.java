package com.cskaoyan.basic.select;

import java.util.Scanner;

/*
        键盘录入月份的值，输出对应的季节。
        3 4 5 春
        6 7 8 夏
        9 10 11 秋
        12 1 2 冬
 */
public class EX2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int month = scanner.nextInt();

        if (month >= 3 && month < 6) {
            System.out.println("春季");
        } else if (month >= 6 && month < 9) {
            System.out.println("夏季");
        } else if (month >= 9 && month < 12) {
            System.out.println("秋季");
        } else {
            System.out.println("冬季");
        }


    }
}
