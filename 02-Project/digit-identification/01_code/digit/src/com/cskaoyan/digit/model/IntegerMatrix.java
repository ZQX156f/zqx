package com.cskaoyan.digit.model;

/**
 * @ClassName IntegerMatrix
 * @Description: TODO 就是训练集、验证集、测试集中的每个样本数据
 * 里面需要包含28*28矩阵，二维数组
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/2 11:28
 * @Version V1.0
 **/
public class IntegerMatrix {

    public int[][] element;

    public IntegerMatrix(int capacity) {
        this.element = new int[capacity][capacity];
    }

    //给当前矩阵的每一位都加smoothing的量
    public void add(Integer smoothing) {
        for (int y = 0; y < this.element.length; y++) {
            for (int x = 0; x < this.element[y].length; x++) {
                element[y][x] = element[y][x] + smoothing;
            }
        }
    }
}
