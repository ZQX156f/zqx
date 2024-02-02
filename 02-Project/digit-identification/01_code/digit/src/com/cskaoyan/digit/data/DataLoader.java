package com.cskaoyan.digit.data;

import com.cskaoyan.digit.model.IntegerMatrix;
import com.cskaoyan.digit.utils.DataConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DataLoader
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/2 11:29
 * @Version V1.0
 **/
public class DataLoader {
    public static List<IntegerMatrix> loadImage(String trainingImagePath, Integer training) {
        //需要读取指定的数据集 使用BufferedReader来读取，因为可以使用readLine方法
        List<IntegerMatrix> sampleList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(trainingImagePath)));
            for (int i = 0; i < training; i++) {
                //一共读取指定的数据量的数据
                //一共读取training数量的数据，那么对应的样本数量也就是training，对应的IntegerMatrix对象也就是这么多
                //为什么写28呢？因为我们的数据样本是28*28的矩阵
                IntegerMatrix integerMatrix = new IntegerMatrix(28);
                //一个样本应该读取28次
                for (int y = 0; y < 28; y++) {
                    String line = bufferedReader.readLine();
                    //此时读取到的是每一行的字符信息，接下来我需要去读取每一位的字符是啥
                    for (int x = 0; x < line.length(); x++) {
                        //就是每一行中的每一个字符，可能是 空字符串、+、#------->转换成0、1、2数字
                        char pixel = line.charAt(x);
                        //空字符串、+、#------->转换成0、1、2数字
                        int value = DataConverter.convert(pixel);
                        integerMatrix.element[y][x] = value;
                    }
                }
                sampleList.add(integerMatrix);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sampleList;
    }

    public static List<String> loadLabel(String trainingLabelPath, Integer training) {
        List<String> labels = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(trainingLabelPath)));

            for (int i = 0; i < training; i++) {
                //读取到的每一行就是一个一个的标记
                String label = bufferedReader.readLine();
                labels.add(label);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return labels;
    }
}
