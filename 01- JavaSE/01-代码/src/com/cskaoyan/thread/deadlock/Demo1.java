package com.cskaoyan.thread.deadlock;

/*
        死锁: 2个或以上线程因为争抢资源而造成的互相等待的现象

        何时会发生死锁？
        1. 一般出现在同步代码块嵌套
        2. 什么情况下出现嵌套锁:  当一个线程要加多把锁

        synchronized(objA){

           // 当线程代码执行到这里
            synchronized(objB){

               // 当线程代码执行到这里，意味着对objA和objB都加锁成功
            }
        }

        假设 访问共享数据做一些运算， 运算结果传输给打印机打印(互斥访问
        1. 对共享数据的访问，实现互斥 (加锁) lockA
        2. 对打印机的访问，也要互斥(加锁) lockB

 */
public class Demo1 {

    public static Object lockA = new Object();

    public static Object lockB = new Object();

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

/*
     1. 先占用打印机的互斥访问权(lockB加锁）
     2. 访问共享数据(lockA加锁)
 */
class BAThread extends Thread {

    @Override
    public void run() {

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
