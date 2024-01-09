package com.cskaoyan.string.api;

/*
        用来比较字符串的内容，注意区分大小写
        boolean equals(Object obj)

        忽略字符串大小写比较字符串内容，常见用于比较网址URL
        boolean equalsIgnoreCase(String str)

        判断当前字符串对象是否包含，目标字符串的字符序列
        boolean contains(String str)

        判断当前字符串对象，是否已目标字符串的字符序列开头
        boolean startsWith(String str)

        判断当前字符串，是否以目标字符串对象的字符序列结尾，常用于确定文件后缀名格式
        boolean endsWith(String str)

        判断一个字符串，是不是空字符串
        boolean isEmpty()
 */
public class Demo1 {

    public static void main(String[] args) {

        String s = "hello world";
        String s1 = new String("hEllo");

        // boolean equals(Object obj)
        System.out.println(s.equals(s1));
        //System.out.println(s == s1);

        //boolean equalsIgnoreCase(String str)
        System.out.println(s1.equalsIgnoreCase(s));

        //boolean contains(String str)
        System.out.println(s.contains("ha"));

        //boolean startsWith(String str)
        System.out.println(s.startsWith("haaa"));

        //boolean endsWith(String str)
        // a.txt  b.mp4
        System.out.println(s.endsWith("aaa"));

        // boolean isEmpty()
        String emptyString = new String("");
        System.out.println(emptyString.isEmpty());




    }
}
