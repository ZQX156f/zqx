package com.cskaoyan.digit.train;

import com.cskaoyan.digit.model.IntegerMatrix;

import java.util.List;

/**
 * @ClassName TrainModel
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/4 10:22
 * @Version V1.0
 **/
public interface TrainModel {

    void train(List<IntegerMatrix> trainImages, List<String> trainLabels);

    void validate(List<IntegerMatrix> validationImages, List<String> validationLabels);
}
