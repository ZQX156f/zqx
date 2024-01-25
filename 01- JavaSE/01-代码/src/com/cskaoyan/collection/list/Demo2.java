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


//        List<E> subList(int fromIndex, int toIndex)
//        返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。
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
            //System.out.println(e);
        }


        //  List<E> subList(int fromIndex, int toIndex)
        // [fromIndex, toIndex)
        // 视图：我们以为字表和它所对应的父表，是不同的对象各自存储各自的数据，但其实不是，它们公用同一份数据
        List<String> strings = list.subList(0, 2);
        System.out.println(strings);
        // 字表中添加元素
        strings.add("abcd");

        // 输出被截取的线性表中的元素
        System.out.println(list);


    }
}
