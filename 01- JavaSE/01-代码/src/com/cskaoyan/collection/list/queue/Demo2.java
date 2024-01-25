package com.cskaoyan.collection.list.queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*
        阻塞队列:
            // 一个大小容量有限的队列
        阻塞条件:
        // 添加操作的时候, 队列添加满了, 添加线程等待
        // 删除操作的时候, 队列删除空了, 删除线程等待

        // BlockingQueue关于添加和删除的方法有四类:
    //       不满足条件抛出异常: add, remove
    //       不满足条件返回特殊值: offer(布尔值), poll(null)
    //       不满足条件一直阻塞: put, take
    //       在指定时间内阻塞:  超时的offer/poll

    //  逻辑上 队列中 应不应该 放入null?

 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {


        // 容量有限，且必须在创建时指定
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

        // 添加元素
        //boolean a = blockingQueue.offer("a");
        //System.out.println(a);
        //a = blockingQueue.offer("b");
        //System.out.println(a);
        //a = blockingQueue.offer("c");
        //System.out.println(a);

        // put方法演示阻塞效果
        //blockingQueue.put("4");

        // take阻塞效果
        //blockingQueue.take();

        //System.out.println("after");

        // 指定阻塞的时间
        //boolean abc = blockingQueue.offer("abc", 5, TimeUnit.SECONDS);

        // 指定阻塞时间
        String poll = blockingQueue.poll(5, TimeUnit.SECONDS);
        System.out.println(poll);

    }
}
