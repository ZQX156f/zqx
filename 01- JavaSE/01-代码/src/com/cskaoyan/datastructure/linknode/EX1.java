package com.cskaoyan.datastructure.linknode;


/*

    判断是否有环
 */
public class EX1 {

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
        //e.next = c;

        boolean result = detectCycle(a);
        System.out.println(result);


    }




    public static boolean detectCycle(ListNode head) {

        if (head == null) {
            return false;
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
                return true;
            }
        }

        // 没有相遇
        return false;

    }
}

class ListNode {

    String value;

    ListNode next;

    public ListNode(String value) {
        this.value = value;
    }
}


