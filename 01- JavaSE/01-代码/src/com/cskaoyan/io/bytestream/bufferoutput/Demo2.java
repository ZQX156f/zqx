package com.cskaoyan.io.bytestream.bufferoutput;

import java.io.*;

/*
         注意事项:
         1. flush方法: 刷新缓冲区， 将包装流缓冲区中的数据，强制写入底层流
         2. close方法: 它在执行之前，会先自动调用一次flush
 */
public class Demo2 {

    public static void main(String[] args) throws IOException {
        // 准备好OutputStream对象
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt", true);

        // 创建缓冲字节输出流对象
        OutputStream os = new BufferedOutputStream(fileOutputStream);

        // 向目标文件写入数据
        byte b = 'h';
        // 写一个字节
        os.write(b);

        byte[] bytes = {'e', 'l', 'l', 'o'};
        // 写入一个字节数组
        os.write(bytes);


        //flush  刷新缓冲区
        os.flush();


        // 关闭流  包装流而言，不需要关闭包装流所包装的底层流，包装流会自动close它锁包装的底层流
        //os.close();

    }
}
