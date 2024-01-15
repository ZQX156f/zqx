package com.cskaoyan.thread.basic;

/*
         方式一VS方式二
            - 步骤上, 方式一4步, 方式二是5步
            - 方式一通过继承的方式(单继承的局限性),方式二通过实现接口的方式
            - 方式二把线程跟线程上要做的事情区分开来(执行路径,跟执行路径上的任务区分开来)  解耦
            - 方式二便于数据共享
 */
public class Demo4 {
}

class Tool {

    public void tool() {


    }
}

// 线程第一种实现方式的局限性，单重继承的限制
//class MySon extends Tool, Thread {
//
//
//    @Override
//    public void run() {
//        tool();
//    }
//}

class MyRunnableTask extends Tool implements Runnable {
    @Override
    public void run() {
        tool();
    }
}


