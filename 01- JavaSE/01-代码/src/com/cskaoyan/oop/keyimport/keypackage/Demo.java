package com.cskaoyan.oop.keyimport.keypackage;


/*

    它写在Java源文件的第一行，用于声明整个Java文件下的所有类的所属包。

    package + 包名

    package关键字的使用很简单，但是有几个需要注意的地方：
    1. 包名在书写时，如果存在多级包名，需要使用用.隔开
    2. package声明必须处在一个Java文件有效代码的第一行，否则会报错
       1. 注释不算有效代码，将package声明放在注释下面也是可以的
       2. 建议将package声明永远放在Java源文件真正意义上的第一行
    3. 多数情况下，我们使用idea新建Java文件是无需关心package声明的，因为idea会自动生成

    什么是全限定类名？
    1. 可以唯一的、准确的定位到一个类的，由包名加上类名组成的字符串，就是全限定类名。
    2. 默认情况下，直接输出一个对象的引用，会打印该类的全限定类名

 */
public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo);
    }
}
