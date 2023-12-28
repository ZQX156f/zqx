package com.cskaoyan.cast;

/*
        练习
 */
public class EX {

    public static void main(String[] args) {

        byte b1 = 1, b2 = 2, b;
        // byte、short、char使用的时候尤其注意取值范围，若参与运算都会自动提升到int
        // b = b1 + b2;
        // byte、short、char使用的时候尤其注意取值范围，若参与运算都会自动提升到int
        //char c = b1 + b2;

        //  一共11个1 超出了int类型表示范围
        long d = 11111111111L;


        // 完成赋值 -128-127
        byte byteValue = (byte)130;
        System.out.println(byteValue);
    }
}
