package com.cskaoyan.thread.basic;

/*
        线程的第二种实现方式:
        1. 定义一个类实现Runnable接口
        2. 重写run方法
        3. 创建子类对象
        4. 创建线程对象, 把实现了Runnable接口的子类对象作为参数传递
        5. start方法启动线程

 */
public class Demo3 {

    public static void main(String[] args) {

        // 3. 创建Runnable接口子类对象
        // 代表了要在线程中执行的任务
        MyRunnable myRunnable = new MyRunnable();

        // 4. 创建线程对象
        Thread thread = new Thread(myRunnable);

        // 5. 启动线程
        thread.start();

    }
}

class MyRunnable implements Runnable {

    /*

         实现的Runnbale接口的run方法中的代码， 会运行在子线程中
     */
    @Override
    public void run() {
        System.out.println("子线程执行了");
    }
}
