package com.cskaoyan.basic.loop;

/*
        循环的嵌套:
        ######
        ######
        ######
        ######

 */
public class Demo4 {

    public static void main(String[] args) {

        // 外层循环控制行
        for (int i = 0; i < 4; i++) {

            // 内层循环输出一行的‘#’
            for (int j = 0; j < 6; j++) {
                System.out.print('#');
            }
            // 换行
            System.out.println();
        }
    }
}
