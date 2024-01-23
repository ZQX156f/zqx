package com.cskaoyan.datastructure.queue;

public class Test {

    public static void main(String[] args) {

        MyArrayQueue<String> queue = new MyArrayQueue<>();

        // 添加元素，测试扩容
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");
        queue.offer("6");
        queue.offer("7");
        queue.offer("8");
        queue.offer("9");
        queue.offer("10");
        queue.offer("11");

        // 出队列
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // 获取对头元素
        System.out.println(queue.peak());

    }
}
