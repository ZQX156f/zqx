package com.cskaoyan.string.api;


import java.util.Arrays;

/*
        获取一个用来表示字符串对象字符序列的，字节数组
        byte[] getBytes()

        获取的是用来表示字符串对象字符序列的，字符数组
        char[] toCharArray()


        把字符数组转换成字符串
        static String valueOf(char[] chs)

        把各种基本数据类型和对象转换成字符串  100---> "100"
        static String valueOf(int i/double...)


        把字符串全部转化为小写
        String toLowerCase()

        把字符串全部转换为大写
        String toUpperCase()

        字符串拼接，作用等价于 + 实现的字符串拼接
        String concat(String str)
 */
public class Demo4 {

    public static void main(String[] args) {
        String s = "abcd";

        // byte[] getBytes()
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

        //char[] toCharArray()
        char[] charArray = s.toCharArray();
        System.out.println(Arrays.toString(charArray));

        //static String valueOf(char[] chs)
        char[] chars = {'c', 'd', 'e'};
        String s1 = String.valueOf(chars);
        System.out.println(s1);

        //static String valueOf(int i/double...)
        String s11 = String.valueOf(100);
        System.out.println(s11); //"100"

        String s12 = String.valueOf("11.1");
        System.out.println(s12); // "11.1"


        String a = "hello WORld";
        // String toLowerCase()
        String lowerCase = a.toLowerCase();

        //String toUpperCase()
        String upperCase = a.toUpperCase();


        System.out.println(lowerCase);
        System.out.println(upperCase);

        //String concat(String str)
        String first = "aaa";
        String second = "bbb";
        String concat = second.concat(first);
        System.out.println(concat);
    }
}
