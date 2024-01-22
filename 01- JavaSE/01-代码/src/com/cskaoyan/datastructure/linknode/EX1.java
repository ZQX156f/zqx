package com.cskaoyan.datastructure.linknode;


/*

    判断是否有环
 */
public class EX1 {




    public static boolean detectCycle(Node1 head) {

        if (head == null) {
            return false;
        }

        // 慢指针
        Node1 slow = head;
        // 快指针
        Node1 fast = head;

        while (fast.next != null && fast.next.next != null) {

            // 快指针移动
        }


    }
}

class Node1 {

    String value;

    Node1 next;

    public Node1(String value) {
        this.value = value;
    }
}


