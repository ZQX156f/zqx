package com.cskaoyan.string.api;


/*
获取当前字符串对象中，包含的字符个数 "abcd"
int length()

获取字符串对象代表字符序列中，指定位置的字符 从0开始"abcd"
char charAt(int index)

在当前字符串对象中查找指定的字符，如果找到就返回字符，首次出现的位置，如果没找到返回-1
也可以填字符   "abcdb"
int indexOf(int ch)

指定从当前字符串对象的指定位置开始，查找首次出现的指定字符的位置，(如果没找到返回-1)
可以填入字符
int indexOf(int ch,int fromIndex)

查找当前字符串中，目标字符串首次出现的位置(如果包含)，找不到，返回-1
这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置  "abcdefg"
int indexOf(String str)

指定，从当前字符串对象的指定位置开始,查找首次出现的指定字符串的位置(如果没找到返回-1)
这里的位置是指目标字符串的第一个字符,在当前字符串对象中的位置
int indexOf(String str,int fromIndex) ，

返回字符串，该字符串只包含当前字符串中，从指定位置开始(包含指定位置字符)到结束的那部分字符串  "abcdef"
String substring(int start)

返回字符串，只包含当前字符串中，从start位置开始(包含)，到end(不包含)指定的位置的字符串  [ , )
String substring(int start,int end)

 */
public class Demo2 {
    public static void main(String[] args) {

        String s = "hello world";

        //int length()
        int length = s.length();
        System.out.println(length);


        //char charAt(int index)
        char x = s.charAt(1);
        System.out.println(x);

        // int indexOf(int ch)
        char c = 'q';
        int charIndex = s.indexOf(c);
        System.out.println(charIndex); //2

        // int indexOf(int ch,int fromIndex)
        int charFromIndex = s.indexOf(c, 3);
        System.out.println(charFromIndex);

        // int indexOf(String str)
        int indexOf = s.indexOf("abcd");
        System.out.println(indexOf);

        //int indexOf(String str,int fromIndex)
        int i = s.indexOf("lo", 1);
        System.out.println(i);

        // String substring(int start)
        String substring = s.substring(5);
        System.out.println(substring);

        //String substring(int start,int end)
        String substring1 = s.substring(2, 5);
        System.out.println(substring1);


    }
}
