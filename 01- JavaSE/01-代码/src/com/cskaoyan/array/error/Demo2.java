package com.cskaoyan.array.error;

/*
        空指针异常: NullPointerException, 访问内存中不存在的数组(对象)
 */
public class Demo2 {

    public static void main(String[] args) {
        // 声明并初始化数组
        int[] array = new int[3];
        // ...
        // null表示不能存在的内存地址
        array = null;

        // 先判断，在使用
        if (array != null) {
            System.out.println(array[0]);
        }





    }
}
