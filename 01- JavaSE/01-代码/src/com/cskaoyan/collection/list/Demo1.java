package com.cskaoyan.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
       // 1, List是Collection的接口的子接口
        // 2, List在Collection作为数据容器定义的基础上, 定义了数据结构为线性表
        // 3, List所有子实现存储数据都有序
        // 4, List允许存储重复数据
        // 5, List允许存储null


        // -----添加删除相关的: List下标相关操作(看一下)---------------------
        //        void add(int index, E element): 根据下标的添加
        //        boolean addAll(int index, Collection<? extends E> c): 根据下标添加所有
        //        E remove(int index): 根据下标的删除
        //        E get(int index): 根据下标获取下标位置存储的内容
        //        int indexOf(Object o): 根据内容查找这个数据出现的第一次下标位置
        //        int lastIndexOf(Object o): 根据内容查找这个数据出现的最后一次下标位置
        //        E set(int index, E element): 根据修改下标位置存储的内容

 */
public class Demo1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        //void add(E element)
        list.add("1");
        //void add(int index, E element)
        list.add(0, "111");


        //E get(int index): 根据下标获取下标位置存储的内容
        String s1 = list.get(0);
        //System.out.println(s1);

        //E set(int index, E element): 根据修改下标位置存储的内容
        list.set(0, "222");
        //System.out.println(list.get(0));


        //list.remove("222");
        //E remove(int index): 根据下标的删除
        //list.remove(0);

        //System.out.println(list); [222, 1]

        Collection<String> fc = new LinkedList<>();
        fc.add("1");
        fc.add("2");

        //boolean addAll(int index, Collection<? extends E> c): 根据下标添加所有
       list.addAll(1, fc);
        //System.out.println(list);

        //int indexOf(Object o): 根据内容查找这个数据出现的第一次下标位置
        //int lastIndexOf(Object o): 根据内容查找这个数据出现的最后一次下标位置

        int firstIndex = list.indexOf("1");
        System.out.println(firstIndex);
        int lastIndex = list.lastIndexOf("1");
        System.out.println(lastIndex);
    }
}
