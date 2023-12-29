package com.cskaoyan.basic.continues;

/*
        continue: 终止循环的一次执行
 */
public class Demo1 {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            if (i == 3) {
//                // 终止一次执行
//                continue;
//            }
//            System.out.println(i + ": hello, world");
//        }


        outer:
        for (int i = 0; i < 3; i++) {
            inner:
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    continue outer;
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
