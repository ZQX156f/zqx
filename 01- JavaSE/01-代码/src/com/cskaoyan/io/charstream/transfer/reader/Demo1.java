package com.cskaoyan.io.charstream.transfer.reader;


import java.io.*;

/*
        InputStreamReader(InputStream in)
        创建一个使用默认字符集的 InputStreamReader。

       InputStreamReader(InputStream in, String charsetName)
       创建使用指定字符集的 InputStreamReader。
 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        FileInputStream fileInputStream = new FileInputStream("a.txt");

        // 1. InputStreamReader(InputStream in)
        //Reader reader = new InputStreamReader(fileInputStream);

        // 2. InputStreamReader(InputStream in, String charsetName)
        Reader reader = new InputStreamReader(fileInputStream, "GBK");
    }
}
