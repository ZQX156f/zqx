package com.cskaoyan.thread.threadsafe.edition2;


/*
        发现了两个问题:
        1. 售卖出了不存在的票 （超卖问题）
        窗口1售出了第1张票
        窗口3售出了第-1张票
        窗口2售出了第0张票

        2. 同一张票售卖多次 （多卖问题）
        窗口2售出了第99张票
        窗口3售出了第99张票

        多线程的数据安全问题: 多线程运行环境下，多个线程访问共享数据，访问到了错误的数据


 */
public class Demo1 {

    public static void main(String[] args) {
        SalesTask salesTask = new SalesTask();

        // 创建线程对象
        Thread first = new Thread(salesTask, "窗口1");
        Thread second = new Thread(salesTask, "窗口2");
        Thread third = new Thread(salesTask, "窗口3");

        // 启动售票线程
        first.start();
        second.start();
        third.start();
    }
}


class SalesTask implements Runnable {


    // 表示待售卖的电影票
    public int tickets = 100;

    @Override
    public void run() {
        // 有票，就可以售票
        while (this.tickets > 0) {

            try {
                // 模拟售票的延迟
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 0. tickets-- a. 读取tickets当前值   b. 运算 -1 c. -1的结果赋值tickets
            // 当前  tickets的值是1
            // 1. 执行字符串的拼接  "窗口1售出了第" + 1 发生了线程切换(运算 -1)
            // 2. 窗口3线程来执行  ”窗口3售出了第“ + 1  发生了线程切换（读取tickets当前值）
            // 3.
            System.out.println(Thread.currentThread().getName() + "售出了第" + this.tickets-- + "张票");
        }

    }
}
