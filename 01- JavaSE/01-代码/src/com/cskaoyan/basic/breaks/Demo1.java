package com.cskaoyan.basic.breaks;

/*
     break: 终止循环（当前的一层循环）
 */
public class Demo1 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                // 终止循环
                break;
            }
            System.out.println(i + ": hello, world");
        }

        System.out.println("after break");


//        outer:
//        for (int i = 0; i < 3; i++) {
//            inner:
//            for (int j = 0; j < 3; j++) {
//                if (i == 1) {
//                    break inner;
//                }
//                System.out.println("i = " + i + ", j = " + j);
//            }
//        }
    }
}
