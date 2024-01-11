package com.cskaoyan.file.api;


import java.io.File;

/*
        // 重新命名此抽象路径名表示的文件
        public boolean renameTo(File dest)
        file对象.renameTo(file对象)

        - 在源文件，和修改之后的目标文件在同一目录的时候：
          - 效果只是重命名
        - 当源文件和，修改之后的目标文件当不在同一目录的时候：
          - 移动文件
          - 重命名
 */
public class Demo4 {

    public static void main(String[] args) {

        // d:\test\a.txt ——> d:\test\aaa.txt
        File srcFile = new File("d:\\test\\a.txt");

        File destFile = new File("d:\\test\\aaa.txt");
        // public boolean renameTo(File dest)
        //boolean b = srcFile.renameTo(destFile);
        //System.out.println(b);



        // d:\test\aaa.txt ——> d:\aac.txt
         srcFile = new File("d:\\test\\aaa.txt");

        destFile = new File("d:\\aac.txt");

        // public boolean renameTo(File dest)
        boolean b1 = srcFile.renameTo(destFile);
        System.out.println(b1);

    }
}
