package com.cskaoyan.io.bytestream.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/*
     从文本文件读取中的内容，输出到控制台窗口("hello,world")
     文件 ——> 内存

     1. 创建字节输入流对象 InputStream ——> 具体子类 FileInputStream
     2. 学习read方法，完成外设 ——> 内存


      FileInputStream：

      1. FileInputStream(File file)
         通过打开一个到实际文件的连接来创建一个 FileInputStream，
         该文件通过文件系统中的  File 对象 file 指定。

      2. FileInputStream(String fileName)
         通过打开一个到实际文件的连接来创建一个 FileInputStream，
         该文件通过文件系统中的路径名  name 指定。
 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("a.txt");
        // 1. FileInputStream(File file)
        //InputStream is = new FileInputStream(file);

        // 2. FileInputStream(String fileName)
        InputStream is1 = new FileInputStream("a.txt");


    }
}
