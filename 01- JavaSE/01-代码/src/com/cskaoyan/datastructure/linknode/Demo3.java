package com.cskaoyan.datastructure.linknode;

/*
        双向链表
 */
public class Demo3 {
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



    }

}

class DBNode {

    // 存储的数据
    String value;

    // 指向前一个节点
    DBNode pre;

    // 指向后一个节点
    DBNode next;

    public DBNode(String value) {
        this.value = value;
    }
}