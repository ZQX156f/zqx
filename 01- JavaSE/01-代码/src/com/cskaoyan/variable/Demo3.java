package com.cskaoyan.variable;

/*
        浮点数因为遵循IEEE754标准，有一个比较大的缺点：由于表示有效数字的位数是有限的，所以精度是受限的。

        下面我们看两个经典案例:
         1. 使用Java代码计算 10 / 3.0
         2. 使用Java代码计算 1 - 0.9

         第一步： 0.1*2    0
         第二步： 0.2*2    0
         第三步:  0.4*2    0
         第四步:  0.8*2    1
         第五步:  0.6*2    1

         0.00011...
 */
public class Demo3 {

    public static void main(String[] args) {
        //  10 / 3.0
        //System.out.println( 10 / 3.0);

        // 1 - 0.9
        System.out.println(1 - 0.9);
    }
}
