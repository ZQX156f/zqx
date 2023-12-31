package com.cskaoyan.recursion;


/*
       递归方法: 自己调用自己的方法
 */
public class Demo1 {

    public static void main(String[] args) {
        recurseWrong();
    }

    public static  void recurseWrong() {

        recurseWrong();
    }
}
