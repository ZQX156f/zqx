package com.cskaoyan.io.charstream.transfer.reader;

import java.io.*;

/*

    int  read()
        读取单个字符。作为整数读取的字符，范围在 0 到 65535 之间 (0x00-0xffff)，
        如果已到达流的末尾，则返回 -1
    int  read(char[] cbuf)
        将字符读入数组。
        返回值表示读取的字符数，如果已到达流的末尾，则返回 -1
    abstract  int read(char[] cbuf,  int off, int len)
        将字符读入数组的某一部分。

 */
public class Demo2 {

    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream("a.txt");
        // 1.创建转化字符输入流对象
        Reader reader = new InputStreamReader(fileInputStream);


        // int  read()
//        int read = reader.read();
//        char c = (char) read;
//        System.out.println(c);

//        int read;
//        while ((read = reader.read()) != -1) {
//            char c = (char) read;
//            System.out.println(c);
//        }

        //  int  read(char[] cbuf)
//        int readCount;
//        char[] chars = new char[1024];
//        while ((readCount = reader.read(chars)) != -1) {
//            String str = new String(chars, 0, readCount);
//            System.out.println(str);
//        }

        // int read(char[] cbuf,  int off, int len)
        int off = 5;
        char[] chars = new char[1024];
        int readCount;

        while ((readCount = reader.read(chars, off, chars.length - off)) != -1) {

            String str = new String(chars, off, readCount);
            System.out.println(str);
        }


        // 3. 关闭流对象
        reader.close();

    }
}
