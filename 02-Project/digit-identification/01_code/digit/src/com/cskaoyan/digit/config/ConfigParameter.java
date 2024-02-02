package com.cskaoyan.digit.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName ConfigParameter
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/2 11:11
 * @Version V1.0
 **/
public class ConfigParameter {
    //里面配置若干静态成员变量，然后在一个静态代码块中去进行赋值操作
    //后续：直接取出里面的静态成员变量便可以取出里面的数据
    public static Integer smoothing;

    public static Integer training;

    public static String trainingImage;

    public static String trainingLabel;

    public static Integer validation;

    public static String validationImage;

    public static String validationLabel;


    public static Integer test;

    public static String testImage;

    public static String testLabel;

    public static Integer iterations;

    static {
        //首先应该从config.properties配置文件中去读取数据
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
            smoothing = Integer.parseInt(properties.getProperty("smoothing"));
            training = Integer.parseInt(properties.getProperty("training"));
            trainingImage = properties.getProperty("training.image");
            trainingLabel = properties.getProperty("training.label");

            validation = Integer.parseInt(properties.getProperty("validation"));
            validationImage = properties.getProperty("validation.image");
            validationLabel = properties.getProperty("validation.label");

            test = Integer.parseInt(properties.getProperty("test"));
            testImage = properties.getProperty("test.image");
            testLabel = properties.getProperty("test.label");

            iterations = Integer.parseInt(properties.getProperty("iterations"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
