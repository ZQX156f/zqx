package com.cskaoyan.array.use;


/*
        1.数组的访问
          a. 数组名 [I@1b6d3586
             1) [ 表示该数据表示的是一个一维数组
             2) I 数组中存储的是int类型的元祖
             3) @ 没有特殊含义, 就是分隔符
             4) 十六进制数 数组在内存中首地址
          b. 数组中元素

        2. 数组元素的赋值

       3. 获取数组长度
         数组的长度可以直接用引用（数组名）获取，语法是：
         int len = 数组名.length;

 */
public class Demo1 {

    public static void main(String[] args) {
        // 声明并初始化一个数组
        int[] array = new int[3];

        // 访问数组名称
        System.out.println(array);

        // 访问数组中的存储单元
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        // 赋值
        array[0] = 100;
        array[1] = 200;
        array[2] = 300;
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        // 获取数组的长度
        int length = array.length;
        System.out.println(length);

    }
}
