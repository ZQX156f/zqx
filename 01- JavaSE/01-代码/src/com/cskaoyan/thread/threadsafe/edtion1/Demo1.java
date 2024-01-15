package com.cskaoyan.thread.threadsafe.edtion1;


/*
      假设A电影院正在上映某电影，该电影有100张电影票可供出售，
      现在假设有3个窗口售票。请设计程序模拟窗口售票的场景。

      1. 三个窗口售票，可不可以同时售票？ 可以，所以三窗口运行在三个独立的线程中
      2. 三个窗口共同售卖100张票 这100张片是三个线程的共享数据


      线程的实现方式2，更便于实现多线程的数据共享

 */
public class Demo1 {

    public static void main(String[] args) {

        // 线程的第一种实现方式
//        SalesWindow window1 = new SalesWindow("窗口1");
//        SalesWindow window2 = new SalesWindow("窗口2");
//        SalesWindow window3 = new SalesWindow("窗口3");
//
//
//        // 启动三个窗口售票
//        window1.start();
//        window2.start();
//        window3.start();


        // 线程的第二种实现方式
        // 表示售票任务
//        SalesTask salesTask = new SalesTask();
//
//        // 创建线程对象
//        Thread first = new Thread(salesTask, "窗口1");
//        Thread second = new Thread(salesTask, "窗口2");
//        Thread third = new Thread(salesTask, "窗口3");
//
//        // 启动售票线程
//        first.start();
//        second.start();
//        third.start();

    }

}

// 线程的第一种实现方式
class SalesWindow extends Thread {

    String windowName;

    public SalesWindow(String windowName) {
        //this.windowName = windowName;
        // Thread(String name)
        super(windowName);
    }

    // 表示待售卖的电影票
    public static int tickets = 100;

    @Override
    public void run() {
        // 有票，就可以售票
        while (this.tickets > 0) {
            System.out.println(getName() + "售出了第" + this.tickets-- + "张票");
        }

    }
}

class SalesTask implements Runnable {


    // 表示待售卖的电影票
    public int tickets = 100;

    @Override
    public void run() {
        // 有票，就可以售票
        while (this.tickets > 0) {

            System.out.println(Thread.currentThread().getName() + "售出了第" + this.tickets-- + "张票");
        }

    }
}
