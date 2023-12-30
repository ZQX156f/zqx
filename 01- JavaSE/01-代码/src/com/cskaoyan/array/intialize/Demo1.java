package com.cskaoyan.array.intialize;

/*
      静态初始化指的是：

    由程序员显式的，指定数组中每个元素的初始值，数组的长度由系统决定（实际上也是由程序员给出的）
    和数组的声明写在一起，语法格式就是：
     数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3...};
     静态初始化有简写的形式，可以省略new关键字，如下：


    数据类型[] 数组名 = {元素1,元素2,元素3...};
    注：简化的形式必须跟在声明之后，不能单独使用！ 下列写法就是错误的：
    数组名 = {元素1,元素2,元素3...};
    当然完整格式可以不和声明写在一起，可以单独使用
 */
public class Demo1 {

    public static void main(String[] args) {
        // 1. 声明数组
        int[] intArray;

        //2. 静态初始化
        intArray = new int[] {1, 2, 3};
        System.out.println(intArray);

        // 一次做完
        double[] doubleArray = new double[] {1.5, 2.5};
        System.out.println(doubleArray);


        // 简化写法
        int[] a = {1, 2, 3};

        //简化写法，只能用在声明数组的时候
        int[] b;
        //b = {1, 2, 3};
    }
}
