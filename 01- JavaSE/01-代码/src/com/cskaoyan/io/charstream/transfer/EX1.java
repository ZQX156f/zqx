package com.cskaoyan.io.charstream.transfer;


import java.io.*;

/*
      可以利用字符流实现文件的复制，文本文件，图片文件，视频文件
      1. 一次复制一个字符
      2. 一次复制一个字符数组

     a. 对于图片和视频数据，它们都有自己特殊的编码格式，它们所使用的编码格式和我们之前讲的
         基于字符集，对字符数据进行的编解码，没有任何关系

      b. 所以，当我们使用字符输入流，来读取图片和视频数据的时候，当字符输入流试图对图片
         和视频数据，进行基于字符集进行解码的时候，会发现有一些二进制数值，
         无法对应到字符集中的字符（遇到不认识的字符）

      c. 此时，字符输入流，要么丢弃这些不认识码值，
         要么把这些没有在字符集中匹配到的编码值替换成特殊编号对应的字符？？？

      其实，这意味着，字符输入流，在读取视频或图片数据的时候，就已经修改了原来的视频和图片

 */
public class EX1 {

    public static void main(String[] args) throws IOException {

//        String srcPath = "d:\\demo\\Demo1.java";
//        String destPath = "d:\\Demo1.java";

//        String srcPath = "d:\\demo\\picture.jpg";
//        String destPath = "d:\\picture.jpg";


        String srcPath = "d:\\demo\\vedio.mp4";
        String destPath = "d:\\vedio.mp4";

        // 一次复制一个字符
        //copyByChar(srcPath, destPath);
        // 一次复制一个字符数组
        copyByChars(srcPath, destPath);

    }

    public static void copyByChar(String srcPath, String destPath) throws IOException {
        //1. 创建流对象
        Writer writer = new OutputStreamWriter(new FileOutputStream(destPath));
        Reader reader = new InputStreamReader(new FileInputStream(srcPath));


        // 文件的复制
        int read;
        while ((read = reader.read()) != -1) {
            // 写一个
            writer.write(read);
        }

        // 3. 关闭流
        writer.close();
        reader.close();
    }


    public static void copyByChars(String srcPath, String destPath) throws IOException {
        //1. 创建流对象
        Writer writer = new OutputStreamWriter(new FileOutputStream(destPath));
        Reader reader = new InputStreamReader(new FileInputStream(srcPath));


        // 文件的复制
        int readCount;
        char[] chars = new char[1024];
        while ((readCount = reader.read(chars)) != -1) {
            // 写一个字符数组
            writer.write(chars, 0, readCount);
        }

        // 3. 关闭流
        writer.close();
        reader.close();
    }



}
