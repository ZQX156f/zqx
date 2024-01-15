package com.cskaoyan.thread.threadsafe.edition3;

/*
      演示基于同步代码块解决多线程数据安全问题

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

        // 使用同步代码块
//      synchronized (lockObj) {
//          while (this.tickets > 0) {
//
//              try {
//                  // 模拟售票的延迟
//                  Thread.sleep(100);
//              } catch (InterruptedException e) {
//                  throw new RuntimeException(e);
//              }
//          }
//      }
            while (this.tickets > 0) {
                try {
                    // 模拟售票的延迟
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (this.lockObj) {

                    // 如果发生了异常
                    // double check
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + "售出了第" + this.tickets-- + "张票");
                    }
                }
            }


    }
}
