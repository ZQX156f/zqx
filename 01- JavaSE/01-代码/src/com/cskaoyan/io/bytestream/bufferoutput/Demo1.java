package com.cskaoyan.io.bytestream.bufferoutput;

import java.io.*;

/*



        BufferedOutputStream(OutputStream out)
        创建一个新的缓冲输出流，以将数据写入指定的底层输出流。默认缓冲区大小是8KB

        BufferedOutputStream: 包装流， 创建一个流接收(封装)一个流对象，并基于该流对象，创建目标流对象
        包装流而言，不需要关闭包装流所包装的底层流，包装流会自动close它锁包装的底层流

 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

        // 准备好OutputStream对象
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");

        // 创建缓冲字节输出流对象
        OutputStream os = new BufferedOutputStream(fileOutputStream);

        // 向目标文件写入数据
        byte b = 'h';
        // 写一个字节
        os.write(b);

        byte[] bytes = {'e', 'l', 'l', 'o'};
        // 写入一个字节数组
        os.write(bytes);


        // 关闭流  包装流而言，不需要关闭包装流所包装的底层流，包装流会自动close它锁包装的底层流
        os.close();



    }
}
