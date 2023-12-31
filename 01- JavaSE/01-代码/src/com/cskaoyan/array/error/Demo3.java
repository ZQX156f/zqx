package com.cskaoyan.array.error;


/*


 数组长度为0和数组为null都是可以使用的，可以认为是经过初始化的，但它们都不是正常数组：
- 长度为0的数组，只在内存中存在结构但没有存储单元，不能存储任何数据。它的操作中：
  - 直接打印数组名可以获取数组对象的地址。
  - 不能访问任何数组下标，否则都会抛出数组下标越界异常。
  - 输出数组的长度为0
- 数组为null，表示数组的引用指向了null，数组（对象）无法进行任何操作。
  - 直接打印数组名得到一个null字符串。"null"
  - 不能访问任何数组下标，也不能打印数组长度，都会报空指针异常。

 */
public class Demo3 {

    public static void main(String[] args) {

        // 动态初始化
        int[] array = new int[0];
        System.out.println(array); //[I@1b6d3586
        //System.out.println(array[0]);
        System.out.println(array.length);

        System.out.println("after array");
        // 静态初始化
        int[] arr = {};
        System.out.println(arr); //[I@4554617c
        //System.out.println(arr[0]);

        // 定义
        int[] b = null;
        System.out.println(b); //null
        System.out.println(b[0]);


    }
}
