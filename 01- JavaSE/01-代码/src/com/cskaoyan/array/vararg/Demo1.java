package com.cskaoyan.array.vararg;

/*
        可变长度参数:
        1. 参数个数不确定的参数
        2. 本质是一个数组

        注意事项:
        1. 一个方法只能有一个可变长参数，并且这个可变长参数必须是该方法的最后一个参数
           只能定义一个可变参数
        2. 调用方法时，如果有一个固定参数的方法匹配的同时，也可以与可变参数的方法匹配，
          则选择固定参数的方法。
        3. 调用方法时，如果出现两个可变参数的方法都能匹配，则报错，这两个方法都无法调用了。

         求不确定个数的int数值之和
 */
public class Demo1 {

    public static void main(String[] args) {
        // 调用可变长度参数的方法

        // 可变长度参数可以表示0个参数
        //test();
        // 可变长度参数可以表示多个参数
        //int test = test(1, 2, 3);
        //System.out.println(test);


        // 模糊的方法调用，两个方法中都包含了可变参数，无法确定调用的是哪个
        //testa(1, 2);

        // 当一个方法包含可变参数，领完一个方法不包含可变参数
        // 调用方法的时候，有确定参数的方法优先级高于有可变参数的方法
        test(1);
    }

    public static int test(int a) {
        System.out.println("test a");
        return 0;
    }

    public static int test(int... a) {

        // 可变长度参数本质其实是一个数组
        //int[] b = a;

        int result = 0;
        for (int i = 0; i < a.length; i++) {
           result += a[i];
        }

        return result;
    }

//  可变参数只能位于参数列表中的最后一个位置
//    public static void testLocation(int... a, int... b) {
//
//    }

    public static void testa(int... var) {
    }

    public static void testa(int a, int... var) {
    }
}
