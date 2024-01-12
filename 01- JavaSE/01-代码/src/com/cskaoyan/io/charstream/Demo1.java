package com.cskaoyan.io.charstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
       假设我们利用字节流读取文件中的字符，并输出，发现问题：
       1. 因为字符我们可以正确的读取
          一个因为字符对应的整数值，一个字节就可以表示了

       2. 中文字符无法正确的读取显示
          但是一个中文字符对应的整数值，它是由多个字节对应的整数来表示
          GBK 2个字节，  UTF-8 3个字节

          只需要让流中的数据编程一个一个‘字符’

          字符流 = 字节流 + 编码表(字符集)

 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("a.txt");

        int read;
        while ((read = is.read()) != -1) {
            char c = (char) read;
            System.out.println(c);
        }

        // 关闭流，释放资源
        is.close();

    }
}
