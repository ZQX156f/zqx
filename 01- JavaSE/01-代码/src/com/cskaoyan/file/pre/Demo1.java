package com.cskaoyan.file.pre;


/*

      访问相对路径默认相对的 目录即用户目录
 */

public class Demo1 {

    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);

        String path = "a.txt";
    }
}
