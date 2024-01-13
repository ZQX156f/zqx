package com.cskaoyan.thread.introduction;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo1 {
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
        Scanner scanner = new Scanner(System.in);
        // 多次输入
        while (flag) {
            String s = scanner.nextLine();
            if ("gun".equals(s)) {
                flag = false;
                break;
            }
        }
    }

    private static void sayHello() {
        while (flag) {
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

