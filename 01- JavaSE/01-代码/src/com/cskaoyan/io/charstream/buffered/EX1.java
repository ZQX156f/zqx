package com.cskaoyan.io.charstream.buffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*

        不使用Scanner对象的前提现，实现nextLine()
        已知System.in如何实现


 */
public class EX1 {

    public static void main(String[] args) throws IOException {

        // 模拟实现读取键盘录入的一行字符串的功能
        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        /*
             1. readLine底层，bufferedReader封装了System.in, 变成了一个阻塞方法
             2. 没有数据录入的时候，不会返回，而是阻塞等待
             3. 当有数据录入，继续正常运行，返回读取到的哪一行字符串
         */
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            // 基于自定义协议
            if ("886".equals(line)) {
                // 终止循环
                break;
            }
            System.out.println(line);
        }

        System.out.println(line);

        // 演示阻塞效果
        //waits();

    }

    private static void waits() {
        // 阻塞的效果
        InputStream in = System.in;

        // 标准输入流的read方法有阻塞效果
//        int result = in.read();
//        System.out.println(result);
    }
}
