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

        发生多线程的数据安全问题:
        1. 多线程运行环境
        2. 多线程访问共享数据
        3. 多线程 对共享数据的访问时 非原子操作

        只需要打破以上三个必要条件其中之一即可:
        1. 多线程运行环境条件  不能打破
        2. 访问共享数据   不可以打破
        3. 非原子操作     可以打破

        如果将多线程对共享数据的访问变成原子操作？
        1. 在一次售票过程中，不发生线程切换， 思路是正确的， 实现不了，我们无法阻止操作系统的线程调度
        2. 允许操作系统发生线程切换，加锁的方式，来实现原子操作
          a. 一把锁有两个装: 加锁状态， 未加锁状态。锁可以被加锁，同时只能倍一个线程加锁成功
             在java语言中，所有java对象都可以充当锁的角色

          b.  加锁: A线程，JVM判断锁对象是否已经加锁，如果没有加锁，A线程加锁成功
                      B线程，JVM判断锁对象是否被加锁，已经被A线程加锁成功，B线程加锁失败，阻塞等待

          c. 释放锁:  当加锁成功的线程，执行完了代码块中的代码，退出同步代码块的时候，JVM自动释放这把锁
                     等待加锁的线程，重新尝试对锁对象加锁


          A线程先执行
          B线程执行
          synchronized (锁对象) {

             多线程访问共享数据的代码
          }



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
            // 超卖问题
            // 当前 tickets的值 1
            // 窗口1线程  tickets = 1 > 0 , 休眠一会(线程切换)
            // 窗口3线程  tickets = 1 > 0, 休眠一会(线程切换)
            // 窗口2线程  tickets = 1 > 0, 休眠一会(线程切换)


            try {
                // 模拟售票的延迟
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 多卖问题
            // 0. tickets-- a. 读取tickets当前值   b. 运算 -1 c. -1的结果赋值tickets
            // 当前  tickets的值是1
            // 1. 执行窗口1字符串的拼接  "窗口1售出了第" + 1 + "张票" 发生了线程切换(运算 -1)
            // 2. 窗口3线程来执行  ”窗口3售出了第“ + 1 + "张票"  发生了线程切换（读取tickets当前值）
            // 3. 窗口2线程执行 "窗口2售出了第" +  1 + "张票"  发生了线程切换（读取tickets当前值）
            System.out.println(Thread.currentThread().getName() + "售出了第" + this.tickets-- + "张票");
        }

    }
}
