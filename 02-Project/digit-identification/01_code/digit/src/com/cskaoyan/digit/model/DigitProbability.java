package com.cskaoyan.digit.model;

/**
 * @ClassName DigitProbability
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/4 14:43
 * @Version V1.0
 **/
public class DigitProbability {

    public String digit;

    public Double probability;

    public DigitProbability(String digit, Double probability) {
        this.digit = digit;
        this.probability = probability;
    }
}
