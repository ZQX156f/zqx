package com.cskaoyan.collection.list.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
        // -----------Queue-----------------
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

    //        E pop()
    //        从此列表所表示的堆栈处弹出一个元素。
    //        void push(E e)
    //        将元素推入此列表所表示的堆栈。

    // 1, ArrayDeque是Deque接口的子实现
    // 2, 数据结构表现:  队列, 双端队列, 栈
    // 3, 底层结构是数组: 循环数组
    // 4, 默认初始长度:16;  默认扩容机制:2倍 --> 数组长度保持2的幂值
    // 5, 存储元素有序
    // 6, 允许存储重复数据
    // 7, 不允许存储null
    // 8, 线程不安全



 */
public class Demo1 {

    public static void main(String[] args) {

        // ArrayDeque数组默认长度16
        Deque<String> firstDeque = new ArrayDeque<>();

        // 我们可以在创建时，可以指定数组长度为任意整数，ArrayDeque它会算出 > 长度的最小的2的幂次
        // 位运算的技巧: int类型，求>任意整数的2的整数次幂
        ArrayDeque<String> secondDeque = new ArrayDeque<>(10);

        // tail = (tail + 1) % elements.length
        // (tail = (tail + 1) & (elements.length - 1)

        //  前提: ArrayDeque是2的整数次幂

        // 13 % 2^4
        // 33 对 16取余
        // 0010 0001
        // 0001 0000

        // 33 对16取余
        // 0010 0001
        // 0001 1111
         //xxxxxxxxxxxxx
        // 0000..0011111
        // 等于 xxxx % (100000)
        //     xxxx & (011111)
        secondDeque.add("aa");


    }
}
