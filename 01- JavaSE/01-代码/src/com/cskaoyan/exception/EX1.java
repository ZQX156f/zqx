package com.cskaoyan.exception;


/*
        单独处理除0异常(基本数据类型)
         空指针,数组下标越界异常一起处理(引用类型的数据产生的异常)
 */
public class EX1 {

    public static void main(String[] args) {

        try {
            //int i = 1 / 0;

            int[] ints = new int[2];
            // 数组越界异常
            //System.out.println(ints[2]);

            ints = null;
            // 空指针异常
            System.out.println(ints[0]);
        } catch (ArithmeticException e) {
            System.out.println("除0异常");
        } catch ( NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("空指针异常 或者 数组越界异常");
        }


    }
}
