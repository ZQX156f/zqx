package com.cskaoyan.thread.api;


/*
       static void sleep(long millis)
       在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。

 */
public class Demo3 {

    public static void main(String[] args) {

        // 创建线程对象
        SleepThread sleepThread = new SleepThread();

        // 启动子线程
        sleepThread.start();
    }
}

class SleepThread extends Thread {

    @Override
    public void run() {
        System.out.println(" start thread");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("end thread");
    }
}
