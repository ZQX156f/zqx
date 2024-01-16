package com.cskaoyan.thread.comunication;

public class Demo2 {
    // 定义一把锁
    public static final Object OBJECT = new Object();
    public static void main(String[] args) {
        // 创建并启动一个线程
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable ,"A").start();

        // sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建并启动一个线程
        new Thread(()->{
            System.out.println("B线程已经执行了");
            // sync
            synchronized (Demo2.OBJECT) {
                System.out.println("B线程进入sync!");
            }
        },"B").start();

    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        synchronized (Demo2.OBJECT) {
            System.out.println("A线程进入sync");
            try {
                // sleep方法在让线程休眠的过程中，线程不会释放锁
                Thread.sleep(10000);
                System.out.println("wait before");
                Demo2.OBJECT.wait();
                System.out.println("wait after");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

