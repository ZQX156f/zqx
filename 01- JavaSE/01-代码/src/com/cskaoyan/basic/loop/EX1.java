package com.cskaoyan.basic.loop;

/*
        1. 用for循环计算1+2+3+...+100
        2. 用for循环求出1-100之间偶数和
        3. 用for循环求5的阶乘
 */
public class EX1 {

    public static void main(String[] args) {

        // 用for循环计算1+2+3+...+100
        int result = 0;
        for (int i = 1; i <= 100 ; i++) {
            result += i;
        }
        //System.out.println(result);

        // 用for循环求出1-100之间偶数和
        result = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        //System.out.println(result);

        // 用for循环求5的阶乘
        result = 1;
        for (int i = 1; i <= 5 ; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
