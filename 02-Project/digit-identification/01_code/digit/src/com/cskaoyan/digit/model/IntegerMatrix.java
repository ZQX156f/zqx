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

    public int multiply(IntegerMatrix weight) {
        int result = 0;
        //矩阵的每一位和形参里面的矩阵的每一位进行相乘运算
        for (int y = 0; y < this.element.length; y++) {
            for (int x = 0; x < this.element[y].length; x++) {
                result += this.element[y][x] * weight.element[y][x];
            }
        }
        return result;
    }

    public void removeWeight(IntegerMatrix trainData) {
        //根据w的更新公式条件  w = w - x
        for (int y = 0; y < this.element.length; y++) {
            for (int x = 0; x < this.element[y].length; x++) {
                //一一对应的位数，将权重当前位置的值 - 当前位置的x的值
                this.element[y][x] -= trainData.element[y][x];
            }
        }
    }

    public void increaseWeight(IntegerMatrix trainData) {
        for (int y = 0; y < this.element.length; y++) {
            for (int x = 0; x < this.element[y].length; x++) {
                //一一对应的位数，将权重当前位置的值 - 当前位置的x的值
                this.element[y][x] += trainData.element[y][x];
            }
        }
    }
}
