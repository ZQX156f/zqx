package com.cskaoyan.basic.loop;

/*
        打印
        #
        ##
        ###
        ####
        #####

        打印九九乘法表

 */
public class EX2 {

    public static void main(String[] args) {

        // 外层控制行
//        for (int i = 1; i <= 5; i++) {
//
//            // 输出一行的#
//            for (int j = 1; j <= i; j++) {
//                System.out.print('#');
//            }
//
//            // 换行
//            System.out.println();
//
//        }


        // 打印99乘法表

        // 外层循环控制行数
        for (int i = 1; i <= 9 ; i++) {

            // 一行的表达式
            for (int j = 1; j <=i ; j++) {

                System.out.print(j + "*" + i + "=" + i * j + '\t');
            }

            // 换行
            System.out.println();
        }

    }
}
