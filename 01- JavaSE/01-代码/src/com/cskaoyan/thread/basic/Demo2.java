package com.cskaoyan.thread.basic;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

/*

    创建线程:
    1. 定义一个类继承Thread类
    2. 重写run方法
    3. 创建子类对象
    4. 通过start方法启动线程

    注意事项:
    1. 运行在run方法中的代码，才会运行在子线程中
    2. run方法中，调用了其他方法，被调用的方法方法也会运行在子线程中
          一个方法，在哪个线程中被调用，运行在哪个线中

    3. 多线程，异步执行， 执行过程是不确定的，随机执行
    4. Thread 或者 Thread 子类对象 才表示一个线程
    5. 注意，启动一个线程，一定调用start方法
    6. 一个线程 是否可以启动多次？ 一个线程只能倍启动

 */
public class Demo2 {

    public static void main(String[] args) {

        // 3. 创建子类对象
        MyThread  first = new MyThread();

        MyThread second = new MyThread();

        // 调用run方法，不能让run方法运行在子线程中，此时它运行在main方法所在main线程
        //first.run();
        //second.run();


        // 4. 启动线程
        first.start();
        //first.start();
        second.start();
    }
}

class MyThread extends Thread {

    static int i = 1;

    int j = i++;
    /*
            执行在run方法中的代码，才会运行在子线程中
     */
    @Override
    public void run() {
        //System.out.println("hello, thread");

        for (int i = 0; i < 100; i++) {
            System.out.println(j + ": " +i);
        }

        // 调用test方法，test方法也会运行在子线程中
        //test();
    }

    public void test() {
        System.out.println("method");
    }


}
