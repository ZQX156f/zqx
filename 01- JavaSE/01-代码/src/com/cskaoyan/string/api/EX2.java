package com.cskaoyan.string.api;

/*
        字符串helloWORLD,第一个字符转为大写,其余字符转为小写     →   Helloworld
 */
public class EX2 {
    public static void main(String[] args) {

        String s = "helloWORLD";

        String headString = s.substring(0, 1);
        String upperHeadString = headString.toUpperCase();


        String substring = s.substring(1);
        String lowerCase = substring.toLowerCase();

        String result = upperHeadString + lowerCase;
        System.out.println(result);

    }
}
