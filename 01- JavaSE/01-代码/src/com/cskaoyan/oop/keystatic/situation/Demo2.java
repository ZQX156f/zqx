package com.cskaoyan.oop.keystatic.situation;

import java.util.Arrays;

/*
        静态方法
         静态方法的最主要特点就是调用简单，无需创建对象即可调用。所以如果要定义公爵方法
         为了方便别人的使用，就可以使用静态方法
 */
public class Demo2 {

    public static void main(String[] args) {
        Tool tool = new Tool();
        tool.test();

        // 方便调用
        Tool.test();

    }
}

class Tool {

    public static void test() {

    }


}
