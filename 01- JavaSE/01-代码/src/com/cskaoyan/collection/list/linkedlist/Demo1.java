package com.cskaoyan.collection.list.linkedlist;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*


// -----------Queue:  -------------
//        boolean offer(E e)
//        将指定元素添加到此列表的末尾（最后一个元素）。
//        E peek()
//        获取但不移除此列表的头（第一个元素）。
//        E poll()
//        获取并移除此列表的头（第一个元素）

// -----------Deque:  -------------
//        boolean offerFirst(E e)
//        在此列表的开头插入指定的元素。
//        boolean offerLast(E e)
//        在此列表末尾插入指定的元素。
//        E peekFirst()
//        获取但不移除此列表的第一个元素；如果此列表为空，则返回 null。
//        E peekLast()
//        获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null。
//        E pollFirst()
//        获取并移除此列表的第一个元素；如果此列表为空，则返回 null。
//        E pollLast()
//        获取并移除此列表的最后一个元素；如果此列表为空，则返回 null。

 */
public class Demo1 {

    public static void main(String[] args) {

        // queue
        Queue<String> queue = new LinkedList<>();

        // 入队列
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        //获取队头元素值
        String peek = queue.peek();
        //System.out.println(peek);

        // 出队列
        String poll = queue.poll();
        //System.out.println(poll);

        // 双端队列
        Deque<Integer> deque = new LinkedList<>();

        //boolean offerFirst(E e)
        deque.offerFirst(1);

        // boolean offerLast(E e)
        deque.offerLast(2);

        // E peekFirst()
        Integer i = deque.peekFirst();
        //System.out.println(i);

        // E peekLast()
        Integer j = deque.peekLast();
        //System.out.println(j);

        //  E pollFirst()
        Integer i1 = deque.pollFirst();
        System.out.println(i1);

        // E pollLast()
        Integer i2 = deque.pollLast();
        System.out.println(i2);


    }
}
