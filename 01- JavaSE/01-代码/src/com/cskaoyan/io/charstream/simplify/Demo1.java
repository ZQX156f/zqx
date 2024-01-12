package com.cskaoyan.io.charstream.simplify;


import java.io.*;

/*
        FileWriter(File file)
        根据给定的 File 对象构造一个 FileWriter 对象。

        FileWriter(String fileName)
        根据给定的文件名构造一个 FileWriter 对象。


      FileReader(File file)
        在给定从中读取数据的 File 的情况下创建一个新 FileReader。

     FileReader(String fileName)
     在给定从中读取数据的文件名的情况下创建一个新 FileReader。

     转化流 VS 简化流
     1. 从创建对象角度，代码书写简单
     2. 从灵活性：简化流无法指定编解码所使用的的字符只能使用默认字符集，转化流可以灵活指定
 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

        //testConstuctor();

        // 创建流对象
        FileWriter fileWriter = new FileWriter("b.txt");
        FileReader fileReader = new FileReader("a.txt");


        char[] chars = new char[1024];
        int readCount;

        while ((readCount = fileReader.read(chars)) != -1) {

            fileWriter.write(chars, 0 , readCount);
        }



        // 关闭流
        fileWriter.close();
        fileReader.close();


    }

    private static void testConstuctor() throws FileNotFoundException {
        // FileWriter(String fileName)
        //FileWriter fileWriter = new FileWriter("a.txt");

        // FileWriter(File file)
        File file = new File("a.txt");
        //FileWriter fileWriter = new FileWriter(file);


        //  FileReader(String fileName)
        //FileReader fileReader = new FileReader("a.txt");

        //FileReader(File file)
        FileReader fileReader1 = new FileReader(file);
    }
}
