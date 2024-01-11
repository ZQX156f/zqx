package com.cskaoyan.file.construct;


import java.io.File;

/*

        文件和目录路径名的抽象表示形式
        1. File对象既可以表示一个文件，也可以表示一个目录
        2. 抽象？ 是相对物理存在来说的，一个File对象所表示的文件或者目录并不一定真实的存在操作系统中
        3. File表示的 逻辑上存在的有一个文件路径唯一确定的那个文件或者目录

        d:\test\a.txt

        // 根据路径名字符串创建File对象
        File (String pathname)
        //  parent: 文件所在的父目录路径
        //  child: 文件在父目录下的相对路径
        File (String parent, Sting child)

        File (File parent, String child)
 */
public class Demo1 {

    public static void main(String[] args) {
        //  File (String pathname)
        // d:\test\a.txt
        //File first = new File("d:\\test\\a.txt");

        //File (String parent, Sting child)
        // d:\test\a.txt
        // d:\test    a.txt
        // d:\     test\a.txt
        //File second = new File("d:\\", "test\\a.txt");

        //File (File parent, String child)
        // 表示父目录
        File dir = new File("d:\\test");
        // d:\test\a.txt
        File third = new File(dir, "a.txt");


    }
}
