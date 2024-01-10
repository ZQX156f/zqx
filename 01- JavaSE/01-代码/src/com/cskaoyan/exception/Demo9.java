package com.cskaoyan.exception;

import java.util.Scanner;

public class Demo9 {

    public static void main(String[] args) {
        try {
            func();

            // 还有其他很多代码 有可能产生很多不同类型的运行时异常 空指针，数组越界
        } catch (MyException2 e) {

        } catch (RuntimeException e) {
            // 可能会遇到很多不同种类的异常
            e.printStackTrace();
        }
    }

    private static void func() {
        // 键盘接收分数
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        // 判读一下是否在区间内
        if (score < 0 || score > 100) {
            // 如果不在 抛出异常
            // throw + 异常对象
            throw new MyException2("分数不合法");
        }
    }
}

// 定义编译时异常
class MyException1 extends Exception{
    public MyException1() {
    }

    public MyException1(String message) {
        super(message);
    }
}

// 定义运行时异常
class MyException2 extends RuntimeException{
    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }
}
