package com.cskaoyan.array.memory;

/*
     栈和堆上的数据，初值不同
     1) 栈上的数据没有默认初值，堆上的东西天生有初值
     2）默认初值
        1. 整数（byte、short、int、long）默认值为0
        2. 浮点类型（float、double）默认值为0.0
        3. 字符类型（char）默认值是'\u0000' 表示编码值为0的字符，一个绝对空字符。''
        4. 布尔类型（boolean）默认值是false
        5. 引用数据类型默认值是null
        null代表不存在的地址
 */
public class Demo3 {

    public static void main(String[] args) {

        int a;
        a = 1;
        System.out.println(a);

        int[] array = new int[2];
        System.out.println(array[0]);

        int[] b;
        //System.out.println(b);

    }
}
