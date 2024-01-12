package com.cskaoyan.io.charstream.transfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
     字符流的注意事项:

 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        // 1. 创建转化字符输出流
        Writer writer = new OutputStreamWriter(fileOutputStream);

        String str = "你好";
        //void write(String str,  int off, int len)
        writer.write(str, 0 ,2);

        // 3. 关闭流
        //writer.close();
    }
}
