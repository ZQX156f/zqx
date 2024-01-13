package com.cskaoyan.thread.api;

/*

        String getName()    返回该线程的名称。
        void setName(String name) 修改线程的名称

        如果想获取 main线程的名称？ 如何实现 Thread.currentThread

        public static Thread currentThread()返回对当前正在执行的线程对象的引用。
 */
public class Demo1 {

    public static void main(String[] args) {

        // 3. 创建子类对象
        NameThead nameThead = new NameThead();

        // 获取线程的名称
        String defaultName = nameThead.getName();
        //System.out.println(defaultName);


        // 修改线程的名称
        //nameThead.setName("first thread");

        // 获取线程名称
        //System.out.println(nameThead.getName());


        // 3. 启动
        //nameThead.start();

        // 获取它所在的main线程的 线程对象的引用
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());  // main

    }
}

class NameThead extends Thread {

    @Override
    public void run() {
        // 在哪个线程中执行，输出的就是那个线程的名字
        String name = this.getName();
        System.out.println(name + " thread");
    }
}
