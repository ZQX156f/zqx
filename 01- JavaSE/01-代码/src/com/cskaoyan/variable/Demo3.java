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

         显然，我们可以得到以下结论：
          很多十进制小数转换成二进制时，会存在循环小数的情况。
          那么有限有效数字的浮点数就不能准确表示这个数字了，那些超出表示位数的数据就被截断丢失了，
          数据失真，精度丢失，这就是浮点数的精度问题。
 */
public class Demo3 {

    public static void main(String[] args) {
        //  10 / 3.0
        //System.out.println( 10 / 3.0);

        // 1 - 0.9
        //System.out.println(1 - 0.9);


        double a = 0.1;
        float b = 0.1F;
        //System.out.println(a == b);

        float a1 = 0.1F;
        float b1 = 0.10000000000000000001F; //中间18个0
        System.out.println(a1 == b1);

    }
}
