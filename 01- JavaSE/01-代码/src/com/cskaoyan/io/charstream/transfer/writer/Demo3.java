package com.cskaoyan.io.charstream.transfer.writer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
     字符流的注意事项:
     1. 缓冲流，自带缓冲区，只是为了实现编解码
     2. 所以当我们写入少量字符数据的时候, 数据可能保留在缓冲区中
     3. close会先调用flush方法，刷新编解码器的缓冲区
     4. flush方法强行将编解码器中的数据，写入底层流中

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
        writer.flush();
    }
}
