package com.cskaoyan.string.api;

/*
    1:字符串反转
	2:举例: 键盘输入abc,反转后结果为cba
 */
public class EX3 {
    public static void main(String[] args) {

        String s = "abc";

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char tmp = charArray[charArray.length - 1 -i];
            charArray[charArray.length - 1 -i] = charArray[i];
            charArray[i] = tmp;
        }

        String s1 = String.valueOf(charArray);
        System.out.println(s1);
    }
}
