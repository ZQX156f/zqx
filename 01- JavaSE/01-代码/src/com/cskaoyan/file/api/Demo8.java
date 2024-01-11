package com.cskaoyan.file.api;


import java.io.File;
import java.util.Arrays;

/*

        //返回一个字符串数组，这些字符串包括，此抽象的路径名表示的目录中的所有文件和文件夹的名字
        //如果File对象表示的是一个文件，则返回null
        //只能获取当前目录的下一层，并不是获取所有层级
        //如果是一个空目录，返回一个长度为0的数组，而不是null  []
        public String[] list()

        //返回指定File目录下的文件和文件夹的绝对路径形式的File对象数组
        //如果File对象表示的是一个文件，则返回null
        //只能获取当前目录的下一层，并不是获取所有层级
        //如果是一个空目录，返回一个长度为0的数组，而不是null
        public File[] listFiles()

 */
public class Demo8 {

    public static void main(String[] args) {

       // 非空目录
        File nonEmptyDir = new File("d:\\test");
        // public String[] list()
        String[] list = nonEmptyDir.list();
        // public File[] listFiles()
        File[] files = nonEmptyDir.listFiles();
        //System.out.println(Arrays.toString(files));

        //System.out.println(Arrays.toString(list));

        // 空目录
        File emptyDir = new File("d:\\test\\first");
        // public String[] list()
        String[] list1 = emptyDir.list();
        //System.out.println(Arrays.toString(list1));
        // public File[] listFiles()
        File[] files1 = emptyDir.listFiles();
        //System.out.println(Arrays.toString(files1));


        // 文件
        File file = new File("a.txt");

        // public String[] list()
        String[] list2 = file.list();
        //System.out.println(list2);

        // public File[] listFiles()
        File[] files2 = file.listFiles();
        System.out.println(files2);


    }
}
