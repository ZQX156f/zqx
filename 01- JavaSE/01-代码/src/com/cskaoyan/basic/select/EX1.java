package com.cskaoyan.basic.select;

import java.util.Scanner;

/*
        键盘录入x的值，计算出y的并输出。

        其中x和y的关系满足如下：

        1. x>=3时，y = 2x + 1;
        2. -1<=x<3时， y = 2x;
        3. x<=-1时， y = 2x – 1;
 */
public class EX1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        int y;
        if (x >= 3) {
            y = 2 * x + 1;
        } else if (x >= -1) {
            y = 2 * x;
        } else {
            y = 2 * x - 1;
        }

        System.out.println(y);
    }
}
