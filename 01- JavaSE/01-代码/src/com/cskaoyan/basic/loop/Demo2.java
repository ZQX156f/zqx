package com.cskaoyan.basic.loop;

/*
        while 循环

        珠峰的高度是8848m，假设有一张足够大可折叠的纸张，初始厚度是0.01m。
        求解这张纸折叠多少次，纸张的厚度开始超过珠峰？
 */
public class Demo2 {

    public static void main(String[] args) {

        // 纸张的初始高度
        double height = 0.01;

        int count = 0;

        while (height < 8848) {
            // 折叠一次，高度变为之前的二倍
            height *= 2;

            // 记录循环的次数
            count++;
        }
        System.out.println("count = " + count);
        System.out.println("height = " + height);


    }
}
