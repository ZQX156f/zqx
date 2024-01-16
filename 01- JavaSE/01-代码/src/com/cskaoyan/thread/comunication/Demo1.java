package com.cskaoyan.thread.comunication;

import com.cskaoyan.oop.block.ex.Demo;

/*

        public final void wait()
          在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
          当前线程必须拥有此对象监视器。
          该线程发布(release)对此监视器的所有权并等待，
          a. 释放锁
          b. 阻塞
          引入一种说法: 如果线程A 因为在锁对象上B调用wait 而处于阻塞状态，我们称线程A 在对象 B上阻塞
    1. 阻塞功能：
        当在某线程中，对象上.wait(), 在哪个线程中调用wait(), 导致哪个线程处于阻塞状态
        当某线程，因为调用执行某对象的wait(),而处于阻塞状态，我们说，该线程在该对象上阻塞。
    2. 唤醒条件
       当某线程，因为某对象A的wait(), 而处于阻塞状态时，如果要唤醒该线程，只能在其他线程中，
       再同一个对象(即对象A)上调用其notify()或notifyAll()
       即在线程的阻塞对象上，调用notify或notifyAll方法，才能唤醒，在该对象上阻塞的线程
    3. 运行条件
          当前线程必须拥有此对象监视器。
          监视器：指synchronized代码块中的锁对象
        即我们只能在，当前线程所持有的synchronized代码块中的，锁对象上调用wait方法，
        才能正常执行
        如果没有锁对象就会有这样一个异常 IllegalMonitorStateException
    4. 执行特征
          a.该线程发布(release)对此监视器的所有权
          b.等待(阻塞)

 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        // wait 执行条件和执行效果

        Demo1 demo1 = new Demo1();

        // 在任意对象上调用wait方法
        //demo1.wait();

        synchronized (demo1) {
            // 成功执行
            System.out.println("before wait");
            // 阻塞当前线程
            demo1.wait();
        }

        System.out.println("after wait");



    }
}
