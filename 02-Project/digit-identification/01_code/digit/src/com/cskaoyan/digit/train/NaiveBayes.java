package com.cskaoyan.digit.train;

import com.cskaoyan.digit.model.IntegerMatrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NaiveBayes
 * @Description: TODO
 * 使用朴素贝叶斯的方式来去求数字识别为某个数字的概率问题
 * 对应的公式：
 * P(Digit0)·P(C0,0=0|Digit0)·........P(C27,27=0|Digit0)------猜测这个数字是0
 * P(Digit1)·P(C0,0=0|Digit1)·........P(C27,27=0|Digit1)------猜测这个数字是1
 * P(Digit2)·P(C0,0=0|Digit2)·........P(C27,27=0|Digit2)------猜测这个数字是2
 * P(Digit3)·P(C0,0=0|Digit3)·........P(C27,27=0|Digit3)------猜测这个数字是3
 * P(Digit4)·P(C0,0=0|Digit4)·........P(C27,27=0|Digit4)------猜测这个数字是4
 * P(Digit5)·P(C0,0=0|Digit5)·........P(C27,27=0|Digit5)------猜测这个数字是5
 * P(Digit6)·P(C0,0=0|Digit6)·........P(C27,27=0|Digit6)------猜测这个数字是6
 * P(Digit7)·P(C0,0=0|Digit7)·........P(C27,27=0|Digit7)------猜测这个数字是7
 * P(Digit8)·P(C0,0=0|Digit8)·........P(C27,27=0|Digit8)------猜测这个数字是8
 * P(Digit9)·P(C0,0=0|Digit9)·........P(C27,27=0|Digit9)------猜测这个数字是9
 * 只要求出上述10个概率值，取出一个最大的概率值，那么便是我们猜测的结果数字
 * 在此期间还需要引入平滑度，防止出现0概率，导致最终结果全部都是0
 * 还需要引入lg和的形式，防止小数相乘之后导致的数值急剧缩小，无法比较的情况
 * 1.先解决P(Digit0)~P(Digit9)先验概率的问题
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/4 10:23
 * @Version V1.0
 **/
public class NaiveBayes implements TrainModel{

    //这个容器用来存放0~9数字出现的次数
    private Map<String, Integer> frequencyMap = new HashMap<>();

    //用来去存储0~9数字在训练集中出现的概率 = 次数 / 总次数   此时不需要引入平滑度
    private Map<String, Double> probabilityMap = new HashMap<>();

    private void calculateProbability(List<String> trainLabels) {
        for (String label : trainLabels) {
            // label:0~9
            Integer times = frequencyMap.getOrDefault(label, 0);
            times ++;
            frequencyMap.put(label, times);
        }

    }

    @Override
    public void train(List<IntegerMatrix> trainImages, List<String> trainLabels) {
        calculateProbability(trainLabels);
    }


}
