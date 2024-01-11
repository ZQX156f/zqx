package com.cskaoyan.io.bytestream.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/*
      向文本文件a.txt写一个字符串"hello,world"
       内存  ——> 磁盘文件

      1. 创建字节输出流  Outputstream的具体子类 FileOutputStream
      2. 如何调用 Outputstream 中的write方法


      学习FileOutputStream构造方法

      FileOutputStream(String filePath)
      创建一个向具有指定名称的文件中写入数据的输出文件流。

      FileOutputStream(File file)
      创建一个向指定 File 对象表示的文件中写入数据的文件输出流。

 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException {

        //  d:\wangdao\repo\2024\a.txt
        // FileOutputStream(String filePath)
        //OutputStream outputStream = new FileOutputStream("a.txt");


        // FileOutputStream(File file)
        File file = new File("a.txt");
        OutputStream os = new FileOutputStream(file);


    }
}
