package com.cskaoyan.datastructure.linknode;


/*
    单向循环链表

 */
public class Demo2 {

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

        // 让最后一个节点(d)的next指向第一个节点(a)
        d.next = a;

        // stackover flow error
        //System.out.println(a);

    }

}
