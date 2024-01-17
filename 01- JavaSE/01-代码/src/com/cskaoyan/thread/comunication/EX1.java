package com.cskaoyan.thread.comunication;

public class EX1 {
    // 定义一把锁
    public static final Object OBJECT = new Object();
    public static void main(String[] args) {

        // 创建B线程 2 4 6.....100
        EvenThread evenThread = new EvenThread();
        new Thread(evenThread,"B").start();

        // sleep
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // 创建A线程 1 3 5....99
        OddThread oddThread = new OddThread();
        new Thread(oddThread,"A").start();


    }
}

class OddThread implements Runnable {

    @Override
    public void run() {
        synchronized (EX1.OBJECT) {
            // 1 3 5 7
            for (int i = 1; i < 100; i+=2) {
                // notify 把对方唤醒
                // 打印第50个值
                EX1.OBJECT.notify();
                // 打印
                System.out.println(Thread.currentThread().getName()+
                        "----"+i);
                // 阻止自己打印 wait
                // 打印99之后 阻塞
                try {
                    EX1.OBJECT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            // 唤醒另一个线程
            EX1.OBJECT.notify();
        }
    }
}

class EvenThread implements Runnable {

    @Override
    public void run() {
        // sync
        synchronized (EX1.OBJECT) {
            // 2 4 6 8 10
            for (int i = 2; i <= 100; i+=2) {
                // 唤醒另一个线程
                EX1.OBJECT.notify();
                // 打印
                // 打印了第50个数100
                System.out.println(Thread.currentThread().getName()+
                        "----"+i);
                // 阻止自己打印 wait
                try {
                    EX1.OBJECT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // notify()唤醒对象
            EX1.OBJECT.notify();

        }
    }
}
