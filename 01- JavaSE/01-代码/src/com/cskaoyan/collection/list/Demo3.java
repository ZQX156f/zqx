package com.cskaoyan.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
        ArrayList 方法来自于List(extends Collection)
        // 1, ArrayList是List接口的子实现
        // 2, ArrayList数据结构是线性表
        // 3, ArrayList底层是数组
        // 4, ArrayList底层持有的数组默认初始长度10, 扩容机制1.5倍
        // 5, ArrayList存储数据有序
        // 6, ArrayList允许存储重复数据
        // 7, ArrayList允许存储null
        // 8, ArrayList线程不安全
 */
public class Demo3 {

    public static void main(String[] args) {

        // 懒初始化
        // 类比(容量 > 1 的生产者消费者缓冲区 )
        ArrayList<String> list = new ArrayList<>();

        //list.add("zs");


        // List 而言有多少种方式可以遍历 线性表中的元素

        // 通用方式 next
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String e = iterator.next();
        }

        // 只针对List的方式
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
        }

        // 通用的方式 Collection 子类
        for (String s : list) {
            System.out.println(s);
        }

        // 只针对线性表的方式
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);
        }

    }

}
