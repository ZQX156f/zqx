package com.cskaoyan.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/*

       failfast
      常见问题: ConcurrentModificationException
               并发修改异常

      发生的情况:
      1. 真的在多线程，有多个线程同时删除(修改list结构)list中的数据
      2. 同一个线程中，既使用iterator remove,  又使用了list的remove来删除
          1） 要么只使用iterator remove删除
          2） 要么使用list中的remove
 */
public class Demo4 {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        // 自动装箱
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(i);
            if (i == 2) {
//                // 使用迭代器删除
//                iterator.remove();
                // 使用list的方法删除
                integers.remove(1);

            }

            if (i == 2) {
                // 迭代器
                iterator.remove();
            }
        }

        System.out.println(integers);


    }
}
