package com.cskaoyan.array.argcall;

/*

 */
public class Demo1 {

    public static void main(String[] args) {
//        int a = 10;
//        // 在方法体中修改形参的值
//        doubleIntValue(a);
//
//        // 输出实参的值
//        System.out.println(a);

        int[] a = {1 , 2, 3};
        testArray(a);

        System.out.println(a);
    }

    public static void doubleIntValue(int a) {
        a *= 2;
    }

    public static void testArray(int[] a) {
        // 修改引用变量所指向的数组的值
        a[0] = 10000;

        // 修改引用变量
        a = null;
    }
}
