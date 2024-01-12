package com.cskaoyan.io.bytestream.bufferinput;

import java.io.*;

/*

        BufferedInputStream(InputStream in)
        创建一个 BufferedInputStream 并保存其参数，即输入流  in，以便将来使用。默认缓冲区8KB


 */
public class Demo1 {

    public static void main(String[] args) throws IOException {
        // 准备好一个底层流
        FileInputStream fileInputStream = new FileInputStream("b.txt");

        // 缓冲字节输入流对象
        InputStream is = new BufferedInputStream(fileInputStream);


        // 一次读取字节数组
        byte[] bytes = new byte[1024];
        int readCount;

        readCount = is.read(bytes);

        String s = new String(bytes, 0, readCount);
        System.out.println(s);



        // 关闭流
        is.close();


    }
}
