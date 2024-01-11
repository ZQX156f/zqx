package com.cskaoyan.io.bytestream;

import java.io.*;

/*
        文件内容的复制
        1.  一次复制一个字节
        2. 一次复制一个字节数组
        为什么一次复制一个字节数组比一次复制一个字节要快？
 */
public class EX1 {

    public static void main(String[] args) throws IOException {

//        String srcPath = "d:\\demo\\Demo1.java";
//        String destPath = "d:\\Demo1.java";

//        String srcPath = "d:\\demo\\picture.jpg";
//        String destPath = "d:\\picture.jpg";


        String srcPath = "d:\\demo\\vedio.mp4";
        String destPath = "d:\\vedio.mp4";
        copyFileByBytes(srcPath, destPath);

    }


    public static void copyFileByByte(String srcPath, String destPath) throws IOException {
        // 1. 创建流对象
        OutputStream os = new FileOutputStream(destPath);
        InputStream is = new FileInputStream(srcPath);


        // 2. 完成赋值
        int read;

        while ((read = is.read()) != -1) {

            // 利用输出流向文件写一个字节
            os.write(read);
        }

        // 关闭流释放资源
        os.close();
        is.close();


    }


    public static void copyFileByBytes(String srcPath, String destPath) throws IOException {
        // 1. 创建流对象
        OutputStream os = new FileOutputStream(destPath);
        InputStream is = new FileInputStream(srcPath);


        // 2. 完成赋值
        int readCount;

        byte[] bytes = new byte[1024];

        while ((readCount = is.read(bytes)) != -1) {

            // 利用输出流向文件写一个字节
            os.write(bytes, 0, readCount);
        }

        // 关闭流释放资源
        os.close();
        is.close();


    }



}
