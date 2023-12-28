package com.cskaoyan.basic.datatype;

/*
     以String类型为例，简单演示引用数据类型
 */
public class Demo2 {

    public static void main(String[] args) {

        // 定义String类型的数据
        String stringVariable1 = "hello, String";

        // 定义第二个引用类型的数据
        String stringVariable2 = "hello, String";


        // 判断应用类型的数据是否相同，不能使用 ==
        System.out.println(stringVariable1.equals(stringVariable2));

        // ???? == 不能判断
    }
}
