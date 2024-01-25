package com.cskaoyan.collection.list.arraylist;

import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
     Vector: 和ArrayList相比，最大的特征，它是线程安全的

    // 1, Vector是List的子实现
    // 2, Vector数据结构为线性表
    // 3, Vector的底层结构是数组
    // 4, Vector底层数组的默认长度10,  扩容机制(如果Vector有大于0的增量, 那么,每次扩容扩大增量个, 如果增量是小于等于0, 每次扩容扩为原来的2倍)
    // 5, Vector存储数据有序
    // 6, Vector允许存储重复数据
    // 7, Vector允许存储null
    // 8, 线程安全 (锁)
    // 9, Vector是jdk1.0的时候出现 (ArrayList在jdk1.2时候出现, ArrayList出现就是为了取代Vector)

     concurrent
        并发容器
 */
public class Demo5 {

    public static void main(String[] args) {

        // 第一个参数 initialCapacitu 数组的初始长度
        // 第二个参数 扩容的增量
        Vector<String> vector = new Vector<>(10, 10);

        vector.add("aaa");

    }
}
