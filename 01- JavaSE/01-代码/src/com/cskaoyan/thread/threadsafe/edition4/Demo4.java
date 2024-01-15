package com.cskaoyan.thread.threadsafe.edition4;

/*

        注意事项:
        1. 我们可以在不同的 同步代码块中， 访问相同的共享数据
        2. 如果我们向仍然保证原子操作，必须保证，多个同步代码块使用同一把锁

 */
public class Demo4 {

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

    public int i = 0;

    // 作为锁对象使用
    private Object firstLock = new Object();

    // 第二个锁对象
    private Object secondLock = new Object();

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

            if (i % 2 == 0) {
                // i为偶数
                i++;
                synchronized (secondLock) {
                    // double check
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName()
                                + "售出了第" + this.tickets-- + "张票");
                    }
                }

            } else {
                // i 是奇数
                i++;
                synchronized (secondLock) {
                    // double check
                    if (tickets > 0) {
                        System.out.println(Thread.currentThread().getName()
                                + "售出了第" + this.tickets-- + "张票");
                    }
                }

            }


        }


    }
}
