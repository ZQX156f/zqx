package com.cskaoyan.thread.threadsafe.note;

import java.util.concurrent.TimeUnit;

public class Demo1 {
    // 定义一把锁
    public static final Object OBJECT = new Object();
    public static int count = 0;
    public static void main(String[] args) {

        TestRunnable testRunnable = new TestRunnable();

        // 创建并启动一个线程
        new Thread(testRunnable,"A").start();
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
            synchronized (OBJECT) {
                System.out.println("B线程进入sync");
            }
        },"B").start();

    }
}

class TestRunnable implements Runnable {


    @Override
    public void run() {
        synchronized (Demo1.OBJECT) {
            System.out.println("A线程进入sync");
            while (true) {
                Demo1.count++;
                try {

                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Demo1.count == 5) {
                    System.out.println(Demo1.count);
                    // 人为制造异常
                    System.out.println(10/0);
                }

            }
        }
    }

}


