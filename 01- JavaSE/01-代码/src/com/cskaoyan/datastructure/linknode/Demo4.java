package com.cskaoyan.datastructure.linknode;

/*
     双向循环链表
 */
public class Demo4 {

    public static void main(String[] args) {


        DBNode a = new DBNode("a");
        DBNode b = new DBNode("b");
        DBNode c = new DBNode("c");
        DBNode d = new DBNode("d");

        // 给pre, next
        // a ——>b
        a.next = b;
        // a<—— b
        b.pre = a;

        // b ——> c
        b.next = c;
        // b <—— c
        c.pre = b;

        // c ——> d
        c.next = d;
        // c <—— d
        d.pre = c;

        // 双向循环链表
        d.next = a;
        a.pre = d;
    }
}
