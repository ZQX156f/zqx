package com.cskaoyan.datastructure.base;

public class Demo3 {

    public static void main(String[] args) {

        // a ——> b ——> c ——> d
        Node a  = new Node("A");

        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        // 构造链表
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("aaa");
    }
}

class Node {

    // 节点中的数据
    String data;

    // next
    Node next;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}
