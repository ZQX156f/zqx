package com.cskaoyan.io.charstream.buffered;

import java.io.*;

/*
       BufferedReader(Reader in)
       创建一个使用默认大小输入缓冲区的缓冲字符输入流。


        BufferedWriter(Writer out)
        创建一个使用默认大小输出缓冲区的缓冲字符输出流。默认缓冲区大小是16KB


 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

        // 创建缓冲流
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b.txt")));
        Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));


        // 文件复制
        int readCount;
        char[] chars = new char[1024];

        while ((readCount = reader.read(chars)) != -1) {
            // 写入一个字符数组
            writer.write(chars, 0, readCount);
        }

        // 关闭流
        writer.close();
        reader.close();


    }
}
