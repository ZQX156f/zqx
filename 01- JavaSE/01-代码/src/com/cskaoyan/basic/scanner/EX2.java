package com.cskaoyan.basic.scanner;

import java.util.Random;
import java.util.Scanner;

/*
     猜数字小游戏
     随机生成一个随机数(0-100), 使用scanner能多次接收一个int数据,
     跟随机数进行比较, 大于或者小于要求给出提示, 重新输入, 直到跟这个随机数相等, 结束.

    1. 如何生成一个随机数
    Random r = new Random();
    // [0, bound) <=> [0, bound-1]
    r.nextInt(int bound);

    2. 多次比较，用到循环

 */
public class EX2 {

    public static void main(String[] args) {
        boolean isSuccess = false;

        // 生成一个随机数
        Random random = new Random();
        // 生成[0, 100]
        int randomValue = random.nextInt(101);


        Scanner scanner = new Scanner(System.in);

        // 没猜中，就一直猜
        while(!isSuccess) {

            // 读取用户所猜的数字
            int userInput = scanner.nextInt();
            if (userInput > randomValue) {
                System.out.println("高了");
            } else if(userInput < randomValue)  {
                System.out.println("低了");
            } else {
                // 猜中了
                System.out.println("猜中");
                isSuccess = true;
            }


        }


    }
}
