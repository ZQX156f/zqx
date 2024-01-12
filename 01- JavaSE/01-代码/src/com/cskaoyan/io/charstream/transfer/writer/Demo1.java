package com.cskaoyan.io.charstream.transfer.writer;


import java.io.*;

/*
        OutputStreamWriter(OutputStream out)
        创建使用默认字符编码的 OutputStreamWriter。

        OutputStreamWriter(OutputStream out,  String charsetName)
        创建使用指定字符集的 OutputStreamWriter。

 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        FileOutputStream fileOutputStream = new FileOutputStream("a.txt");
        // 创建转化流对象
        //OutputStreamWriter(OutputStream out) 使用默认字符集
        //Writer writer = new OutputStreamWriter(fileOutputStream);


        // OutputStreamWriter(OutputStream out,  String charsetName)
        Writer writer = new OutputStreamWriter(fileOutputStream, "GBK");

    }
}
