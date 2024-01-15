package com.cskaoyan.thread.deadlock.edition2;

/*
     死锁问题的第二种解决问题的方案:
     让一个线程要么不加锁，要么加锁就加两把锁 ———> 加两把锁变成原子操作

     synchronized (锁对象) {

        synchronized (Demo1.lockA) {

            synchronized (Demo1.lockB) {
            }
        }

     }
 */
public class Demo1 {

    public static Object lockA = new Object();

    public static Object lockB = new Object();

    public static Object allLock = new Object();

    public static void main(String[] args) {
        ABThread abThread = new ABThread();
        BAThread baThread = new BAThread();

        // 启动线程
        abThread.start();
        baThread.start();
    }
}


/*
      先访问共享数据
      访问打印机
 */
class ABThread extends Thread {

    @Override
    public void run() {


        synchronized (Demo1.allLock) {
            synchronized (Demo1.lockA) {
                // 对共享数据的互斥访问

                System.out.println("ABThread 访问共享数据");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 做运算
                // 访问打印机
                synchronized (Demo1.lockB) {

                    // 访问打印机
                    System.out.println("ABThread 获取打印机访问权");
                }
            }
        }


    }
}

/*
     1. 先占用打印机的互斥访问权(lockB加锁）
     2. 访问共享数据(lockA加锁)
 */
class BAThread extends Thread {

    @Override
    public void run() {

        synchronized (Demo1.allLock) {
            // 先占用打印机的互斥访问权
            synchronized (Demo1.lockB) {

                System.out.println("BAThread 获取打印机访问权");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 访问共享数据，做运算
                synchronized (Demo1.lockA) {

                    System.out.println("BAThread 访问共享数据");

                }
            }
        }


    }
}
