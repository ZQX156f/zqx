package com.cskaoyan.set;


import java.util.Iterator;
import java.util.TreeSet;

/*
        TreeSet:
 */
public class Demo2 {

    public static void main(String[] args) {
        TreeSet<String> objects = new TreeSet<>();

        // 保证元素唯一
        // 放入TreeSet中的元素必须可以比较大小
        // 1. 元素类型 implements Comparable接口
        // 2. public TreeSet(Comparator<? super E> comparator)
        objects.add("aaa");

        Iterator<String> iterator = objects.iterator();
    }
}
