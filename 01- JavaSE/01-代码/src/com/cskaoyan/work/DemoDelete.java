package com.cskaoyan.work;

import java.io.File;

public class DemoDelete {

    public static void main(String[] args) {

    }


    public static void delete(File dir) {
        File[] files = dir.listFiles();

        if (files.length == 0) {
            // dir 空目录 直接删除
            dir.delete();
            return;
        }

        // 遍历当前目录的子目录和子文件
        for (File file : files) {

            if (file.isDirectory()) {
                // 目录 递归删除目录
                delete(dir);
            } else {
                // 文件
                file.delete();
            }
        }

        // dir已经成为一个空目录
        dir.delete();

    }
}
