package com.cskaoyan.pacman.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ClassUtils
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 11:39
 * @Version V1.0
 **/
public class ClassUtils {
    public static List<Class> getAllClasses() throws ClassNotFoundException {
        String classPath = ClassUtils.class.getClassLoader().getResource("").getPath();
        if(classPath.startsWith("/")){
            classPath = classPath.substring(1);
        }
        List<String> classFiles = new ArrayList<>();
        recursiveFiles(new File(classPath), classFiles);
        classFiles = removePrefix(classFiles, classPath);
        List<Class> classList = transferFileToClass(classFiles);
        return classList;
    }

    /**
     * 将文件转换成全类名类
     * 比如com/cskaoyan/pacman/model/Pacman.class------> com.cskaoyan.pacman.model.Pacman
     * @param classFiles
     * @return
     */
    private static List<Class> transferFileToClass(List<String> classFiles) throws ClassNotFoundException {
        List<Class> classList = new ArrayList<>();
        for (String classFile : classFiles) {
            int index = classFile.indexOf(".");
            String className = classFile.substring(0, index);
            //全类名类
            className = className.replace("/", ".");
            classList.add(Class.forName(className));
        }
        return classList;
    }

    /**
     * 将文件的classpath部分的前缀去掉
     * @param classFiles
     * @param classPath
     * @return
     */
    private static List<String> removePrefix(List<String> classFiles, String classPath) {
        List<String> files = new ArrayList<>();
        for (String classFile : classFiles) {
            files.add(classFile.replace(classPath, ""));
        }
        return files;
    }

    private static void recursiveFiles(File file, List<String> classFiles) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                recursiveFiles(f, classFiles);
            }
        }else {
            String absolutePath = file.getAbsolutePath();
            if(absolutePath.contains("\\")){
                absolutePath = absolutePath.replaceAll("\\\\", "/");
            }
            classFiles.add(absolutePath);
        }
    }
}
