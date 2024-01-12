package com.cskaoyan.io.charstream.transfer;


import java.io.*;

/*

        abstract void write(int c)
        写入单个字符。

        write(char[] cbuf)
        写入字符数组。

        void write(char[] cbuf,  int off, int len)
        写入字符数组的某一部分。

        void write(String str)
        写入字符串。

        void write(String str,  int off, int len)
        写入字符串的某一部分

 */
public class Demo2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        // 1. 创建转化字符输出流
        Writer writer = new OutputStreamWriter(fileOutputStream);


        // write方法写数据
        char c = '我';
        //void write(int c)
        //writer.write(c);



        char[] chars = {'是', '一', '个','c', 'o', 'd', 'e', 'r'};
        //write(char[] cbuf)
        //writer.write(chars);

        //void write(char[] cbuf,  int off, int len)
        //writer.write(chars, 3, 5);

        // void write(String str)
        String str = "王道训练营";
        //writer.write(str);

        //void write(String str,  int off, int len)
        writer.write(str, 0 ,2);


        // 3. 关闭流
        writer.close();

    }
}
