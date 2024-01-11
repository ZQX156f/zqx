package com.cskaoyan.file.api;


import java.io.File;

/*
        创建目录:
        //只负责创建目录，但只能创建单层目录，如果有多级目录不存在的话，创建失败
        public boolean mkdir()

        file对象.mkdir()

        //只负责创建目录，但可以创建多级目录，如果多级目录不存在，则帮你全部创建
        public boolean mkdirs()

        mkdir 和 mkdirs创建目录的区别：

       mkdir仅能在已经存在的目录下，创建新的目录
       mkdirs 当要创建的目标目录，如果目标目录的父目录不存在的时候，
       它会将不存在的目标木目录的父目录 连同目标目录一起，都创建好

 */
public class Demo2 {

    public static void main(String[] args) {

        // d:\test\first
        //File first = new File("d:\\test\\first");

        //public boolean mkdir()
        //boolean mkdir = first.mkdir();
        //System.out.println(mkdir);


        // d:\test\second\third
        File third = new File("d:\\test\\second\\third");
        //public boolean mkdir()
        boolean mkdir1 = third.mkdirs();
        System.out.println(mkdir1);

    }
}
