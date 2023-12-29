package com.cskaoyan.basic.returns;

/*
        return: 结束整个方法，可以存在于方法体中的任意一个位置
 */
public class Demo {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            if (i == 3) {
//                // 终止循环
//                return;
//            }
//            System.out.println(i + ": hello, world");
//        }
//
//        // 不会执行，原因为return终止了整个方法的执行
//        System.out.println("after return");


        for (int i = 0; i < 3; i++) {
            inner:
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    return;
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
