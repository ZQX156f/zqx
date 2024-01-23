package com.cskaoyan.datastructure.stack;

import java.util.NoSuchElementException;

public class MyLinkedStack<E> {


    // 头结点模拟栈顶
    private Node top;

    private int size;

    /*
         入栈
     */
    public boolean push(E e) {
        if (top == null) {
            top = new Node(e);
            size++;
            return true;
        }

        // 在top之前插入元素
        Node node = new Node(e);
        node.next = top;
        top = node;
        size++;
        return true;
    }

    /*
         出栈
     */
    public E pop() {
        if (top == null) {
            //return null;
            throw new NoSuchElementException();
        }

        E e = top.value;
        top = top.next;
        size--;
        return e;
    }

    /*
        获取栈顶元素值
     */
    public E peak() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.value;
    }



    class Node {
      E value;

      Node next;

        public Node(E value) {
            this.value = value;
        }
    }
}
