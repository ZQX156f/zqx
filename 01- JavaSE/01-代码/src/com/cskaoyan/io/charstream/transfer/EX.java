package com.cskaoyan.io.charstream.transfer;

import java.io.*;

/*
     注意事项:
     1. 读取一个文件的内容乱码
     2. 显示的编解码不一致

 */
public class EX {

    public static void main(String[] args) throws IOException {

        // 1. 创建流对象
//        Reader reader
//                = new InputStreamReader(new FileInputStream("d:\\a.txt"), "GBK");
//
//
//        char[] chars = new char[1024];
//        int readCount = reader.read(chars);
//
//        String s1 = new String(chars, 0, readCount);
//        System.out.println(s1);
//
//        // 关闭流
//        reader.close();


        // 项文件中写入数据
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
//                new FileOutputStream("d:\\b.txt"), "gbk");
//
//        outputStreamWriter.write("我是程序员");
//
//        // 关闭流
//        outputStreamWriter.close();


        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("d:\\b.txt"), "gbk");

        char[] chars = new char[1024];

        int readCount = inputStreamReader.read(chars);

        String s1 = new String(chars, 0, readCount);
        System.out.println(s1);


    }
}
