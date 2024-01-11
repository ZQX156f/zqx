package com.cskaoyan.io.bytestream.output;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*

        OutputStream write方法：

        abstract  void write(int b)
        将指定的字节写入此输出流。
        write 的常规协定是：向输出流写入一个字节。
        要写入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。

       void write(byte[] b)
       将 b.length 个字节从指定的 byte 数组写入此输出流。

        void write(byte[] b,  int off, int len)
        将指定 byte 数组中从偏移量 off 开始的  len 个字节写入此输出流。

 */
public class Demo2 {

    public static void main(String[] args) throws IOException {

        // 1. 创建流对象
        OutputStream os = new FileOutputStream("a.txt");


        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        // 2. 调用输出流的write方法
        // 1) void write(int b) 一次写入一个字节
        for (int i = 0; i < chars.length; i++) {
            os.write(chars[i]);
        }

        // 3. 释放系统资源
        os.close();

    }
}
