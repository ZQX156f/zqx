package com.cskaoyan.io.bytestream.input;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*

        int read()
        从输入流中读取数据的下一个字节。
        返回 0 到 255 范围内的 int 字节值。
        如果因为已经到达流末尾而没有可用的字节，则返回值 -1。

        int read(byte[] b)
        从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
        读入缓冲区的总字节数；如果因为已经到达流末尾而不再有数据可用，则返回 -1。
        返回值表示读取的字节的个数

        int read(byte[] b,  int off, int len)
        将输入流中最多 len 个数据字节读入 byte 数组。

 */
public class Demo2 {

    public static void main(String[] args) throws IOException {

        boolean flag = true;


        // 1. 创建流对象
        InputStream is = new FileInputStream("a.txt");


        // 测试read() 方法
        //testReadNoArg(is, flag);

        // int read(byte[] b) 1024 整数倍

        byte[] bytes = new byte[1024];

        // readCount表示实际读取到的字节个数
//        int readCount = is.read(bytes);
//        System.out.println(readCount);
//
//        // 转化成字符串输出
//        String s = new String(bytes, 0,readCount);
//        System.out.println(s);
//
//
//        // 数据读取完毕返回-1
//        readCount = is.read(bytes);
//        System.out.println(readCount);

        int readCount;
        while ((readCount = is.read(bytes)) != -1) {

            String s = new String(bytes, 0, readCount);
            System.out.println(s);
        }

        is.close();



    }

    private static void testReadNoArg(InputStream is, boolean flag) throws IOException {
        // int read()
        int read = is.read();
        char c1 = (char) read;
        System.out.println(c1);

        read = is.read();
        char c2 = (char) read;
        System.out.println(c2);

        read = is.read();
        char c3 = (char) read;
        System.out.println(c3);

        read = is.read();
        char c4 = (char) read;
        System.out.println(c4);

        read = is.read();
        char c5 = (char) read;
        System.out.println(c5);

        // 文件内容读完，返回-1
        read = is.read();
        System.out.println(read);


        //3. 关闭流，释放系统资源
        //代表读取到的字节值
        //int read;
        //第一种写法
        while (flag) {
            read = is.read();
            if (read == -1) {
                // 数据读取完毕，已经到达流末尾
                break;
            }

            // 输出
            char c = (char) read;
            System.out.println(c);

        }

        //第二种写法

        while ((read = is.read()) != -1) {
            char c = (char) read;
            System.out.println(c);
        }
    }
}
