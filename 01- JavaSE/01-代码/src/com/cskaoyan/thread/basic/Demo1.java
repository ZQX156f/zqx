package com.cskaoyan.thread.basic;

/*
      验证JVM天生多线程

      同时还有一个线程，清理立即 GC

      java程序，到底是所有Java程序运行在同一个JVM中，还是每个Java程序运行在独立的JVM
      每一个Java程序对应的进程，JVM进程

 */
public class Demo1 {

    public static void main(String[] args) {

        int[] array = null;

        while (true) {
            //
            array = new int[8192];
            array = null;
        }

    }
}
