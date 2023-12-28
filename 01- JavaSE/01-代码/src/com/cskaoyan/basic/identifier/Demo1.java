package com.cskaoyan.basic.identifier;

/*
        - 标识符的开头必须是：
          1. 字母（A~Z 和 a~z）
          2. 下划线（_）
          3. 美元符号（$）
          4. Unicode 字符集中编号为0xC0以及它后面的所有符号
        - 标识符的组成必须是：
          1. 数字（0~9）
          2. 字母（A~Z 和 a~z）
          3. 美元符号（$）
          4. 下划线（_）
          5. Unicode 字符集中编号为0xC0以及它后面的所有符号

          注意事项:
          标识符不能是Java中的关键字和保留字，并且标识符严格区分大小写。
 */
public class Demo1 {

    public static void main(String[] args) {

        int a1 = 1;
        int A = 1;
        int _A = 3;
        int $a = 1;
        int 你 = 1;
        int の = 1;



        // 数字字符不能打头
        //int 1a = 1;

        // 严格区分大小写
        int b = 1;
        int B = 2;

        // 符合java语法
        int headInQueueOfFile = 1;
    }
}
