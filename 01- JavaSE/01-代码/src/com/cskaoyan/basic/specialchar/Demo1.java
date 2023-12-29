package com.cskaoyan.basic.specialchar;

/*
        \b： 退格，删除前一个字符
        \r:  将光标移动到行首
        \t： 制表符，大的空格
 */
public class Demo1 {

    public static void main(String[] args) {

        // \b
        //System.out.println("aaabbbc\b");

        // \r
        System.out.println("aab\rbccdd");

        // \t
        System.out.println("a\tb");

        // \\表示的是一个'\'
        System.out.println('\\');


    }
}
