package com.cskaoyan.array.oeration.get;

/*
      获取数组中的最大值：
      1) max, min初值问题
      2) 如果数组中有多个最大值或者多个最小值，习惯返回最先访问到的最值
 */
public class Demo1 {

    public static void main(String[] args) {


    }


    public static int max(int[] a) {
        // 第一种初值方式
        //int max = a[0];
        // 第二种赋值方式，int类型的最小值
        int max = Integer.MIN_VALUE;

        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    public static int min (int[] a) {
        // 第一种初值方式
        //int min = a[0];
        // 第二种赋值方式，int类型的最小值
        int min = Integer.MAX_VALUE;

        for (int value : a) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}
