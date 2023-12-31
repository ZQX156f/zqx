package com.cskaoyan.array.error;


/*
     数组下标越界异常:  访问数组中不存在的元素(不合法的下标)
 */
public class Demo1 {

    public static void main(String[] args) {
        // 声明并初始化(存在的合法下标 0, 1,2)[0, length-1]
        int[] a = {22, 33, 11};

        // 访问
        System.out.println(a[3]);
    }
}
