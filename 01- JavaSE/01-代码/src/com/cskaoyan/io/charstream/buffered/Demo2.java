package com.cskaoyan.io.charstream.buffered;

import java.io.*;

/*

        BufferedReader:
           String readLine();
            1. 读取字符串的一行，如果返回null表示到达流末尾
            2. 读取的内容中不包含换行符


        BufferdWriter:
          void newLine()
          向流中写入当前操作系统默认的换行符

        按行复制文本的功能

 */
public class Demo2 {

    public static void main(String[] args) throws IOException {

        // 创建缓冲流对象
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("b.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));



        // 按行复制
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            bufferedWriter.write(line);
            // 写入换行符
            bufferedWriter.newLine();
        }


        // 关闭流
        bufferedReader.close();
        bufferedWriter.close();


    }
}
