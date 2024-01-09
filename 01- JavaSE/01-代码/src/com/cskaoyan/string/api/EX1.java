package com.cskaoyan.string.api;

public class EX1 {

    public static void main(String[] args) {
        String s = "abc001DEF";
        //traverseString(s);

        // 大写字符
        int firstCount = 0;
        // 小写字符
        int secondCount = 0;
        // 数字字符
        int thirdCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                // 小写字符
                secondCount++;
            } else if (c >= 'A' && c <= 'Z') {
                // 大写字符
                firstCount++;
            } else {
                // 数字字符
                thirdCount++;
            }
        }

        System.out.println("大写字符出现 " + firstCount + "次");
        System.out.println("小写字符出现 " + secondCount + "次");
        System.out.println("数字字符出现 " + thirdCount + "次");


    }


    public static void traverseString(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c + " ");
        }
    }


}
