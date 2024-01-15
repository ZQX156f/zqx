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


 */
public class Demo1 {

}

class ABThread {}
