package com.cskaoyan.string.buffer;

/*
    public StringBuffer() // 默认容量是16
    public StringBuffer(int capacity)// 容量是capacity
    public StringBuffer(String str)// str的长度+16
 */
public class Demo2 {

    public static void main(String[] args) {

        // 创建一个value长度为16的可变字符串
        StringBuffer stringBuffer = new StringBuffer();

        //public StringBuffer(int capacity)
        StringBuffer stringBuffer1 = new StringBuffer(100);

        // public StringBuffer(String str)
        StringBuffer stringBuffer2 = new StringBuffer("hello");

    }
}
