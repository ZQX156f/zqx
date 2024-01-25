package com.cskaoyan.map.properties;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
   Properties

 */
public class Demo1 {


    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        FileReader fileReader = new FileReader("a.txt");

        // 读取配置文件中的键值对
        properties.load(fileReader);

        String value1 = properties.getProperty("age");
        System.out.println(value1);
        String value2 = properties.getProperty("size");
        System.out.println(value2);

    }
}
