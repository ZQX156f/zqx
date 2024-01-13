package com.cskaoyan.thread.introduction;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static boolean flag = true;
    public static void main(String[] args) {

        System.out.println("main before");
        System.out.println("hello before");

        sayHello();
        System.out.println("hello after");

        System.out.println("wait before");
        waitToStop();
        System.out.println("wait after");


        System.out.println("main after");

    }

    private static void waitToStop() {

        // 创建线程并启动
        WaitToStop waitToStop = new WaitToStop();
        new Thread(waitToStop).start();

    }

    private static void sayHello() {
        // 创建线程并启动
        SayHello sayHello = new SayHello();
        new Thread(sayHello).start();

    }
}

class SayHello implements Runnable {


    @Override
    public void run() {
        while (Demo2.flag) {
            System.out.println("你好");
            try {
                // 让程序暂停执行3秒
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WaitToStop implements Runnable {


    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        // 多次输入
        while (Demo2.flag) {
            String s = scanner.nextLine();
            if ("gun".equals(s)) {
                Demo2.flag = false;
                break;
            }
        }
    }
}
