package com.cskaoyan.datastructure.linknode;

public class EX2 {

    public static void main(String[] args) {

        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        ListNode d = new ListNode("d");
        ListNode e = new ListNode("e");

        // 连接
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // 成环
        e.next = c;

        ListNode node = findCycleStart(a);
        System.out.println(node.value);

    }


    public static ListNode findCycleStart(ListNode head) {

        if (head == null) {
           return null;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {

            // 快指针移动
            fast = fast.next.next;
            // 慢指针
            slow = slow.next;

            if (slow == fast) {
                // 相遇
                break;
            }
        }

        if (slow != fast) {
            // 无环，返回null
            return null;
        }

        //  有环，slow == fast
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
