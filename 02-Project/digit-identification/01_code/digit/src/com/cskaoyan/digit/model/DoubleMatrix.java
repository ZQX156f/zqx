package com.cskaoyan.digit.model;

/**
 * @ClassName DoubleMatrix
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/4 11:23
 * @Version V1.0
 **/
public class DoubleMatrix {

    public double[][] element;

    public DoubleMatrix(int capacity) {
        this.element = new double[capacity][capacity];
    }
}
