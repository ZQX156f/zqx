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

        char c = 'c';
        // 单引号字符本身
        System.out.println('\'');

        String s = "";
        // 双引号
        System.out.println('\"');

        // \ddd 三个八进制树表示一个字符
        System.out.println("\141");

        // uxxxx
        System.out.println("\u0061");



        System.out.println("aaabbbc\b");
        System.out.println("aaa\nbbbc");
        System.out.println("aaa\tbbb");
        System.out.println("aaa\\bbb");
        System.out.println("aaa\'bbb");
        System.out.println("\111");


    }
}
