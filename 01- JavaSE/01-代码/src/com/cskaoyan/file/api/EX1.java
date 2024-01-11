package com.cskaoyan.file.api;


import java.io.File;

/*
      1. 判断某个目录(单级)下有没有 .txt文件,有的话输出
      2. 判断某个目录(单级)下有没有 .java文件,有的话输出
      3.

 */
public class EX1 {

    public static void main(String[] args) {

        File dir = new File("d:\\test");
        // 找txt文件
        findTxtFile(dir);
    }


    public static void findTxtFile(File dir) {

        // 先利用高级获取功能，获取目标目录下的所有子文件和子目录
        File[] files = dir.listFiles();

        // 遍历数组，根据条件判断
        for (int i = 0; i < files.length; i++) {

            String name = files[i].getName();
            // 判断条件
            if (files[i].isFile() && name.endsWith(".java")) {
                System.out.println(files[i].getAbsolutePath());
            }
        }

    }

//    public static void findAllFile(File dir, ) {
//
//        // 先利用高级获取功能，获取目标目录下的所有子文件和子目录
//        File[] files = dir.listFiles();
//
//        // 遍历数组，根据条件判断
//        for (int i = 0; i < files.length; i++) {
//
//            String name = files[i].getName();
//            // 判断条件
//            if (files[i].isFile() && name.endsWith(".java")) {
//                System.out.println(files[i].getAbsolutePath());
//            }
//        }
//
//    }
}
