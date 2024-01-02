package com.cskaoyan.recursion;

/*
       递归求解  1-n自然数的和
       1. 递推公式 (分解，递归的方式)
       2. 初值条件 (递归出口条件)

       f(n) = f(n - 1) + n
       f(1) = 1

 */
public class Demo3 {

    public static void main(String[] args) {
        int sum = sum(5);
        System.out.println(sum);

    }


    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }

        // 按照递推公式分解子问题
        return n + sum(n - 1);
    }
}
