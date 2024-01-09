package com.cskaoyan.string.api;


/*
    String类的替换功能
    在新的字符串中，用新(new)字符，替换旧(old)字符  "abcd"
    String replace(char old,char new)

    在新的字符串中，用新的字符串(new), 替换旧(old)字符串
    String replace(String old, String new)


    在新的字符串中，去掉开头和结尾的空格字符 "abc"  "abc "
    String trim()

    分隔功能
    将字符串按照符号分隔成字符串数组  "a,b,c,d"
    String[] split(String re)

    String类的比较功能
    int compareTo(String str)
    int compareToIgnoreCase(String str)
 */
public class Demo5 {

    public static void main(String[] args) {
        String s = "hello worldllo";

        // String replace(char old,char new)
        String replace = s.replace('o', 'a');
        System.out.println(replace);


        // String replace(String old, String new) llo ——> abcdefg
        String replace1 = s.replace("llo", "abcdefg");
        System.out.println(replace1);

        // String trim()
        String str = " aaa bbb ";
        String trim = str.trim();
        System.out.println("---" + trim + "---");

    }
}
