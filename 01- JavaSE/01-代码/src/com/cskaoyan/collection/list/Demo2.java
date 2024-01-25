package com.cskaoyan.collection.list;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
       hasNext 判断是否有下一个元素
       next() 获取下一个元素
    //        ListIterator<E> listIterator()
    //         index 指的是cursor起始位置
    //        ListIterator<E> listIterator(int index):
    // 		  提供了一个从某个位置开始, 不仅可以向后遍历, 也可以向前遍历的方式previous()
      previous()
 */
public class Demo2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        // 添加元素
        list.add("zs");
        list.add("ls");
        list.add("ww");
        //ListIterator<E> listIterator()
        ListIterator<String> itr = list.listIterator();

        // next
        while (itr.hasNext()) {
            String e = itr.next();
            //System.out.println(e);
        }

        // previous
        //ListIterator<E> listIterator(int index)
        ListIterator<String> listItr = list.listIterator(list.size());
        while (listItr.hasPrevious()) {
            String e = listItr.previous();
            System.out.println(e);
        }

    }
}
