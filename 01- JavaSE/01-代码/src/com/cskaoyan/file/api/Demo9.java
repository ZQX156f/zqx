package com.cskaoyan.file.api;


import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/*
       public interface FileFilter {
               测试指定抽象路径名是否应该包含在某个路径名列表中。
               boolean accept(File pathname)
       }

       如果要表示具体的过滤条件，我们得定义具体的实现子类

       public File[] listFiles(FileFilter filter)


 */
public class Demo9 {

    public static void main(String[] args) {

        File dir = new File("d:\\test");

        // 一个具体的过滤条件对象
        JavaFileFilter javaFileFilter = new JavaFileFilter();

        // 另外一个不同的过滤条件
        TxtFileFilter txtFileFilter = new TxtFileFilter();

        //findAllFile(dir, javaFileFilter);
        //findAllFile(dir, txtFileFilter);

        // 使用jdk中的listFiles方法
        // 仅仅包含满足条件的文件或目录对应File对象
        File[] files = dir.listFiles(javaFileFilter);
        System.out.println(Arrays.toString(files));

        File[] files1 = dir.listFiles(txtFileFilter);
        System.out.println(Arrays.toString(files1));

    }






    public static void findAllFile(File dir, FileFilter fileFilter) {

        // 先利用高级获取功能，获取目标目录下的所有子文件和子目录
        File[] files = dir.listFiles();

        // 遍历数组，根据条件判断
        for (int i = 0; i < files.length; i++) {
            // 判断条件
            if (fileFilter.accept(files[i])) {
                System.out.println(files[i].getAbsolutePath());
            }
        }

    }


}

class JavaFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        return file.isFile() && name.endsWith(".java");
    }
}

class TxtFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        return file.isFile() && name.endsWith(".txt");
    }
}
