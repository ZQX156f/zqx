package com.cskaoyan.thread.api;

import java.sql.SQLOutput;

/*
        int getPriority();
        void setPriority(int priority)

        注意:
        1. 线程的优先级有10个级别  1 - 10, 数值越大，优先级越高
        2. 默认优先级是5
        3. 然而，优先级其实并没有什么用

        java语言中，优先级对操作系统来说，只是一个建议，实际上不会起到决定作用

 */
public class Demo2 {

    public static void main(String[] args) {

        // 创建线程对象
        PriorityThread priorityThread = new PriorityThread();

        // 线程的默认优先级
        int priority = priorityThread.getPriority();
        System.out.println(priority); // 5

        // 修改线程优先级
        priorityThread.setPriority(Thread.MAX_PRIORITY);
        //System.out.println(priorityThread.getPriority());


        PriorityThread maxThread = new PriorityThread();
        maxThread.setName("MAX");
        maxThread.setPriority(Thread.MAX_PRIORITY);


        PriorityThread minThread = new PriorityThread();
        minThread.setName("MIN");
        minThread.setPriority(Thread.MIN_PRIORITY);

        // 启动线程
        maxThread.start();
        minThread.start();

    }
}

class PriorityThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ", i =" + i);
        }

    }
}
