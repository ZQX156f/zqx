package com.cskaoyan.recursion;


/*
       递归方法: 自己调用自己的方法
       注意事项:
       1. 递归方法要有递归出口
       2. 递归深度不能太深
 */
public class Demo1 {

    public static void main(String[] args) {
        // 没有出口条件的递归方法
        // recurseWrong();

        // 有出口条件的递归方法
        recurseRight(Integer.MAX_VALUE);
    }

    public static  void recurseWrong() {
        // 自己调用自己
        recurseWrong();
    }

    public static void recurseRight(int n) {
        // 首先定义递归出口(条件)
        if (n < 0) {
            return;
        }
        System.out.println(n);
        n--;
        recurseRight(n);
    }
}
