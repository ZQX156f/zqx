package com.cskaoyan.thread.threadsafe.edition5;

/*
      我们可以将整个方法体，定义为一个同步代码块，这样的方法我们称之为同步方法
      1. 非静态成员方法，锁对象，调用成员方法的当前对象
      public synchronized void saleSingleTicket() {


      }

      2. 静态方法而言，其锁对象，指的是类 对应 Class对象
      public synchronized static void staticMethod () {
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

    // 作为锁对象使用
    private Object lockObj = new Object();

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

            // 运行在子线程中的
            this.saleSingleTicket();

        }


    }

    public synchronized void saleSingleTicket() {
        // this
        // 三个线程使用的Runnable对象，当做锁对象
            // double check
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "售出了第" + this.tickets-- + "张票");
            }
    }

    /*
        静态方法也可以是同步方法
     */
    public synchronized static void staticMethod() {

    }
}
