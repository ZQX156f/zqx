package com.cskaoyan.io.charstream;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
    在java语言： 编解码 针对 字符串

    编码:  字符串  ——>  字符串中每一个字符对应的编码值 byte[]

    getBytes()

 */
public class Demo2 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // 编码
        String s = "你好";

        // 编码
        byte[] bytes = s.getBytes("utf-8");
        System.out.println(Arrays.toString(bytes));

    }
}
