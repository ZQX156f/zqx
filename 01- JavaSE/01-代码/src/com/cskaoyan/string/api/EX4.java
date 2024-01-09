package com.cskaoyan.string.api;

import java.util.Arrays;

/*
    	1:给出一句英文句子： "i want a bing dun dun"
        2:每个单词的首字母都转换为大写并输出
        3.使用split方法

 */
public class EX4 {

    public static void main(String[] args) {

        String s = "i want a bing dun dun";

        // 分隔单词
        String[] words = s.split(" ");
        System.out.println(Arrays.toString(words));

        String result = "";
        for (int i = 0; i < words.length; i++) {
            String currenWord = words[i];


            String newWord = currenWord
                    .substring(0, 1)
                    .toUpperCase()
                    .concat(currenWord.substring(1));

            result += newWord + " ";
        }

        System.out.println(result);

    }
}
