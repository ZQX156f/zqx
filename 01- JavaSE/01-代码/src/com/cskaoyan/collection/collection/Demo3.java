package com.cskaoyan.collection.collection;

import java.util.*;

/*
    // -----------特殊方法: 帮助我们对Collection进行遍历的---------------------------
    //        Object[] toArray()
    //        返回包含此 collection 中所有元素的数组。
    //        <T> T[] toArray(T[] a)
    //        返回包含此 collection 中所有元素的数组；返回与指定数组的运行时类型相同。
    //        Iterator<E> iterator()
    //        返回在此 collection 的元素上进行迭代的迭代器。

            public interface Iterator<E> {

            boolean hasNext();

            E next();
           }

 */



public class Demo3 {

    public static void main(String[] args) {

        // 创建数据容器
        Collection<String> first = new ArrayList<>();

        // 添加元素
        first.add("zs");
        first.add("ls");

        // Object[] toArray()
        Object[] array = first.toArray();
        // 可能需要强制类型转化
        String s = (String) array[0];
        //System.out.println(s);

        // <T> T[] toArray(T[] a)
        // 数组长度两种情况: 0 或者 size
        String[] strings = new String[first.size()];
        String[] firstArray = first.toArray(strings);
        for (int i = 0; i < firstArray.length; i++) {
            //System.out.println(firstArray[i]);
        }


        // 返回包含此 collection 中所有元素的数组；返回与指定数组的运行时类型相同。
        // Iterator<E> iterator()
        // 获取迭代器
        Iterator<String> iterator = first.iterator();

        while (iterator.hasNext()) {
            String e = iterator.next();
            //System.out.println(e);
        }

        // 指向另外一种实现子类对象
        first = new LinkedList<>();
        first.add("java");
        first.add("c++");
        first.add("c");

        Iterator<String> itr = first.iterator();

        while (itr.hasNext()) {
            String e = itr.next();
            System.out.println(e);
        }


    }
}
