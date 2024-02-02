package com.cskaoyan.digit.start;

import com.cskaoyan.digit.config.ConfigParameter;
import com.cskaoyan.digit.data.DataLoader;
import com.cskaoyan.digit.model.IntegerMatrix;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName DataClassifier
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/2 11:24
 * @Version V1.0
 **/
public class DataClassifier {

    public static void main(String[] args) {
        //首先先读取配置文件里面的配置项，去读取训练数据集和训练集的标记
        String trainingImagePath = ConfigParameter.trainingImage;
        String trainingLabelPath = ConfigParameter.trainingLabel;
        //写一个工具类，用来去读取训练集、测试集、验证集的数据和标记
        //每个样本可以取一个名字，叫做IntegerMatrix
        List<IntegerMatrix> trainImages = DataLoader.loadImage(trainingImagePath, ConfigParameter.training);
        //还需要进一步去处理标记label
        List<String> trainLabels = DataLoader.loadLabel(trainingLabelPath, ConfigParameter.training);
    }
}