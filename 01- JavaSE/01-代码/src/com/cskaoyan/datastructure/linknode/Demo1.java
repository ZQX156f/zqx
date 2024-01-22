package com.cskaoyan.datastructure.linknode;

/*
      单链表
 */
public class Demo1 {

    public static void main(String[] args) {
        // 构造链表
        // a ——> b ——> c ——> d
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        // 分别指向其下一个节点
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println(a);
    }
}

class Node {

    // 数据
    String value;

    // next
    Node next;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                //  拼接的时候，调用了next所指向的下一个Node的toString
                ", next=" + next +
                '}';
    }
}
