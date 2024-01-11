package com.cskaoyan.file.api;

import java.io.File;

/*
        // 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除
        public boolean delete()

 */
public class Demo5 {

    public static void main(String[] args) {

        // d:\test\first
        File emptyDir = new File("d:\\test\\first");

        // public boolean delete()
        //boolean delete = emptyDir.delete();
        //System.out.println(delete);

        // d:\test\second
        File nonEmptyDir = new File("d:\\test\\second");
        // public boolean delete()
        //boolean delete1 = nonEmptyDir.delete();
        //System.out.println(delete1);


        // d:\test\b.txt
        File file = new File("d:\\test\\b.txt");
        // public boolean delete()
        boolean delete = file.delete();
        System.out.println(delete);


    }
}
