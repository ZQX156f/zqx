package com.cskaoyan.method.basic;


/*
      方法调用
 */
public class Demo2 {

    public static void main(String[] args) {

        // 方法调用
        // 调用方法是实际传递的参数值，我们称之为实际参数
        int result = getSum(100, 20);
        System.out.println(result);
        int a = 1000;
        print((byte) a);
    }


    // 计算2个数的和
    public static int getSum(int a, int b) {
        // 方法体
        int sum = a + b;
        // Missing return statement
        return sum;
        // 上下是等价的
        // return a + b;
    }

    public static void print(byte a) {
        System.out.println(a);
    }
}
