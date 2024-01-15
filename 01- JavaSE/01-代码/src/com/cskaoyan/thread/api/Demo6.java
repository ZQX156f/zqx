package com.cskaoyan.thread.api;


/*
        static void yield()
        1. 暂停当前正在执行的线程对象 (暂停自己)
        2. 并执行其他线程。 （调用别人）

        yield方法只能让自己放弃cpu执行权，

 */
public class Demo6 {

    public static void main(String[] args) {

        // 第一个线程对象
        YieldThread first = new YieldThread();
        // 第二个线程对象
        YieldThread second = new YieldThread();

        first.start();
        second.start();
    }
}

class YieldThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": i = " + i);
            // 礼让
            Thread.yield();
        }
    }
}
