package com.cskaoyan.file.api;

import java.io.File;

/*
        // 判断File对象是否表示的是一个文件
        public boolean isFile()

        //判断File对象是否表示的是一个目录
         public boolean isDirectory()

        //判断，File对象表示的文件，是否物理存在
        public boolean exists()
 */
public class Demo6 {

    public static void main(String[] args) {


        // d:\test\a.txt
        File file = new File("d:\\test\\a.txt");

        //public boolean isFile()
        boolean isFile = file.isFile();
        //System.out.println(isFile);
        //public boolean isDirectory()
        boolean isDirectory = file.isDirectory();
        //System.out.println(isDirectory);

        // 文件存在
        boolean exists = file.exists();
        //System.out.println(exists);

        File notExistsDir = new File("d:\\test\\first");
        boolean exists1 = notExistsDir.exists();
        System.out.println(exists1);
    }

}
