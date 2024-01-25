package com.cskaoyan.map.hashmap;

import java.util.HashMap;

/*
         loadfactor
        // 1, HashMap是Map接口的子实现
        // 2, HashMap的底层结构:  数组+链表+红黑树(红黑树是在Jdk1.8时候引入的结构)
        // 3, 数组的默认初始长度16,  扩容机制2倍, 加载因子默认是0.75
        // 4, HashMap存储数据无序
        // 5, HashMap不允许存储重复的key (什么叫重复? )
        // 6, HashMap允许存储null作为key
        // 7, 线程不安全

 */
public class Demo1 {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("a", 1);
    }
}
