package com.cskaoyan.thread.api;

/*
        void join()
        等待该线程终止。
        1.  谁等待?  在哪个线程里调用join方法，哪个线程就等待
        2.  等待谁?  在哪个线程对象上调用join方法，等待哪个线程执行完

 */
public class Demo5 {

    public static void main(String[] args) throws InterruptedException {

        // 3. 创建线程对象
        JoinThread joinThread = new JoinThread();



        // 调用join
        // 看到的效果就是， main线程等待子线程执行完，然后在接着执行main线程
        //joinThread.join();

        //System.out.println("main end");

        SecondThread secondThread = new SecondThread(joinThread);

        // 4. 启动线程
        joinThread.start();
        secondThread.start();


    }
}

class JoinThread extends Thread {


    @Override
    public void run() {
        System.out.println("start thread");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("end thread");
    }
}

class SecondThread extends Thread {

    Thread thread;

    public SecondThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        try {
            // 先等待其他线程执行完，自己再来执行
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("second thread");
    }
}
