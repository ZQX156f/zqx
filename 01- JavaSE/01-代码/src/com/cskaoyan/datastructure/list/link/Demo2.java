package com.cskaoyan.datastructure.list.link;

import java.util.Objects;

/*
      基于双向链表实现的线性表
      1. 基本的按内容增删改查
      2. 根据位序实现
 */
public class Demo2 {

    public static void main(String[] args) {

        MyDBLinkedList<String> stringMyDBLinkedList = new MyDBLinkedList<>();
        stringMyDBLinkedList.add("1");
        stringMyDBLinkedList.add("2");
        stringMyDBLinkedList.add("3");

        String string = stringMyDBLinkedList.toString();
        System.out.println(string);


//        MyDBLikedList myDBLikedList = new MyDBLikedList();
//
//        // 按内容增删改查
//        //testContent(myDBLikedList);
//
//        // 测试位序操作
//        myDBLikedList.add(0, "0");
//        myDBLikedList.add(1, "1");
//        myDBLikedList.add(2, "2");
//        myDBLikedList.add(1, "aaa");
//
//
//        // 修改指定位置的元素值
//        myDBLikedList.set(1, "abc");
//        myDBLikedList.set(3, "ddd");
//        myDBLikedList.set(0, "yyy");
//
//
//        myDBLikedList.remove(3);
//        myDBLikedList.remove(1);
//        myDBLikedList.remove(0);
    }

//    private static void testContent(MyDBLikedList myDBLikedList) {
//        myDBLikedList.add("1");
//        myDBLikedList.add("2");
//        myDBLikedList.add("3");
//
//        myDBLikedList.set("3", "333");
//        myDBLikedList.set("1", "111");
//
//        myDBLikedList.remove("3");
//        myDBLikedList.remove("1");
//        myDBLikedList.remove("2");
//    }
}


