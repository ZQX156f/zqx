package com.cskaoyan.datastructure.list.link;

import java.util.Objects;

/*
      基于双向链表实现的线性表
      1. 基本的按内容增删改查
      2. 根据位序实现
 */
public class Demo2 {

    public static void main(String[] args) {

        MyDBLikedList myDBLikedList = new MyDBLikedList();

        myDBLikedList.add("1");
        myDBLikedList.add("2");
        myDBLikedList.add("3");
    }
}

class MyDBLikedList {

    // 指向双向链表的第一个节点
    private Node head;

    // 指向双向链表的最后一个节点
    private Node tail;

    private int size;

    /*
        向双向链表末尾插入新的节点，节点的value值是指定值
     */
    public boolean add (String value) {
        if (head == null) {
            // 待插入的元素是双向链表中的第一个节点
            head = new Node(value);
            tail = head;
            size++;
            return true;
        }

        // 找到链表的尾节点
        Node node = new Node(value);
        node.pre = tail;
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    /*
        在链表中删除指定value值的节点
     */
    public boolean remove(String value) {

        if (head == null) {
            // 链表是空的
            return false;
        }

        // 非空链表
        if (Objects.equals(head.value, value)) {
            // 第一个节点
            if (size == 1) {
                // 只剩一个节点的时候
                head = null;
                tail = null;
                size--;
                return true;
            }

            // 将第二个阶段前驱变为null
            head.next.pre = null;
            head = head.next;
            size--;
            return true;
        }

        // 删除中间或者尾节点
        Node mid = head;
        while (mid.next != null && !Objects.equals(mid.next.value, value)) {
            mid = mid.next;
        }

        //
    }



  class Node {

      String value;

      Node pre;

      Node next;

      public Node(String value) {
          this.value = value;
      }
  }
}
