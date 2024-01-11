package com.cskaoyan.file.api;


import java.io.File;
import java.io.IOException;

/*
        //只负责创建文件，目录路径如果不存在，会报错而不是帮你创建
        public boolean createNewFile()

        file对象.createNewFile()

 */
public class Demo1 {

    public static void main(String[] args) throws IOException {

        // 创建File对象
        File file = new File("d:\\test\\b.txt");

        //创建file对象所表示的文件
        //boolean newFile = file.createNewFile();
        //System.out.println(newFile);


        // 报错
        File f = new File("e:\\a.txt");

        boolean newFile1 = f.createNewFile();
        System.out.println(newFile1);

    }
}
