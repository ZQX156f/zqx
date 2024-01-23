package com.cskaoyan.datastructure.generic.base;


import java.util.ArrayList;

/*

      演示使用Object数组的问题
 */
public class Test {

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList();

        // 添加数据
        myArrayList.add("1");

        // 添加整数
        Integer a = 1;
        //myArrayList.add(a);

        // 添加小数
        Float f = 15.5f;
        //myArrayList.add(a);

        String s1 = myArrayList.get(0);
        System.out.println(s1);


    }
}

class A {}
class B extends A {}
