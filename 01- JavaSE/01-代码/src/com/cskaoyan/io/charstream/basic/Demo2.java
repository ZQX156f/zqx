package com.cskaoyan.io.charstream.basic;


import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/*
    在java语言： 编解码 针对 字符串

    编码:  字符串  ——>  字符串中每一个字符对应的编码值 byte[]
    getBytes("字符集")

    解码: byte[] ——> 字符串
    new String(byte[], int off, int len, 字符集的名字)

    getBytes()
    new String(byte[], int off, int len)
    默认字符集:
     1. 当我们开发者在编解码的时候，如果没有指定字符集，默认就是用jdk默认字符集来进行编解码
        a). 在IDEA中默认字符集 UTF-8
        b). 在操作系统中默认字符集 GBK (等于操作系统的默认字符集)

    gbk 2个字节表示一个中文字符，UTF-8 3个字节表示一个中文字符


 */
public class Demo2 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // 编码
        String s = "你好";

        // 编码
        // utf-8
        byte[] utf8Bytes = s.getBytes("utf-8");
        //System.out.println(Arrays.toString(utf8Bytes));

        // gbk
        byte[] gbkBytes = s.getBytes("GBK");
        //System.out.println(Arrays.toString(gbkBytes));


        // 解码:
        // utf-8
        String utf8Str = new String(utf8Bytes, 0, utf8Bytes.length, "utf-8");
        //System.out.println(utf8Str);

        // gbk
        String gbkStr = new String(gbkBytes, 0, gbkBytes.length, "gbk");
        //System.out.println(gbkStr);

        // 在IDEA中
        String str = new String(utf8Bytes, 0, utf8Bytes.length);
        System.out.println(str);


        // 获取默认字符集
        System.out.println(Charset.defaultCharset());

        // 乱码
        String wrongStr = new String(utf8Bytes, 0, utf8Bytes.length, "UTF-8");
        System.out.println(wrongStr);


        // 基于ascii字符集
        byte[] bytes = s.getBytes("ascii");
        String s1 = new String(bytes, 0, bytes.length, "ascii");
        System.out.println(s1);


    }
}
