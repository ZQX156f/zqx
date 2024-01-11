package com.cskaoyan.file.api;


import java.io.File;

/*
        //获取File对象表示的抽象文件的绝对路径
        public String getAbsolutePath()

        //获取File对象表示的抽象文件，路径名字符串
         public String getPath()

        //获取文件或者目录的名字
         public String getName()

        //返回由此抽象路径名表示的文件的长度。不能返回文件夹的长度
        //此抽象路径名表示的文件的长度，以字节为单位；如果文件不存在，则返回 0L
         public long length()

        //返回此抽象路径名表示的文件最后一次被修改的时间。
        //表示文件最后一次被修改的时间的 long 值，用与时间点（1970 年1月1日，00:00:00 GMT）之间的毫秒数表示
        public long lastModified()

 */
public class Demo7 {

    public static void main(String[] args) {

        // 相对路径创建File对象  "a.txt"
        File file = new File("a.txt");

        // file对象所表示文件的绝对路径
        // public String getAbsolutePath()
        String absolutePath = file.getAbsolutePath();
        // D:\wangdao\repo\2024\a.txt
        //System.out.println(absolutePath);

        // public String getPath()
        String path = file.getPath();
        // a.txt
        //System.out.println(path);

        //public String getName() 包含类型后缀
        String name = file.getName();
        //System.out.println(name);

        // public long lastModified()
        // the epoch
        long l = file.lastModified();
        //System.out.println(l);

        //public long length()
        long length = file.length();
        System.out.println(length);


    }
}
