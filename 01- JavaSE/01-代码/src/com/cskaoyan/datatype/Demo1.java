package com.cskaoyan.datatype;

/*
      基本数据类型（Base Data Type）指的是由Java语言默认提供的八种数据类型，它们的存储空间一般都是固定的。
      整型有四种：

        - byte
          - byte类型也叫字节型，仅占1个字节内存空间，即8位。

        - short
          - short 也叫短整型，占用2个字节内存空间，16位。
          - 短整型只比字节型稍大，实际开发中short使用频率也不高。
        - int
          - int 本身就是单词integer的缩写，占用4个字节内存空间, 即32位
          - **int 是最常用的整数数据类型，实际开发中整数往往都是int类型的。**
        - long
          - long 也叫长整型，占用8个字节内存空间, 即64位
          - 当int类型不足以存储数据时，就需要使用long类型存储数据，在需要很大的整数时才需要使用long类型。

          Java程序的数字进制:
            - 0b 表示的是二级制
            - 0 表示的是八级制
            - 0x 表示的是十六级制
            - 默认的是十进制

         浮点型有两种：
            - **float**
              - float 即单精度的浮点数，占用4个字节内存空间，32位。
              - float 相对于double占用空间更小，但它不如double精度高，也没有double表示范围大。
            - **double**
              - double 双精度的浮点数，占用8个字节内存空间，64位。
              - double更精确，范围更大，是更常用的浮点数类型。
         char本身就是单词"字符"character的缩写，每一个char类型变量都表示某一个字符，它具有以下特点：

            - Java中的char类型变量占用2个字节内存空间。

            - Java中的char类型存储字符，实际是存储了一个16位的无符号正整数值。

              注：十六位无符号数，16位全部用来存储数值，只能表示整数，取值范围是[0,65535]。
              即Java中的char类型能够表示编码值在[0,65535]范围内的的所有字符。

         所谓布尔类型就非常简单了，就是表示真（true）和假（false）。

和字符类型类型，布尔类型也只有一个：boolean类型，它具有以下特点：

- boolean，布尔类型，用来存储真（true）和假（false）两种布尔值，**没有其它取值**。
- 布尔类型变量具体占用内存的大小，要分情况而定（以下作简单了解）根据JVM规范中提供的数据：
  1. 一个独立的boolean类型变量当作int处理，占4个字节。
  2. 在boolean数组当成byte数组处理，一个boolean元素占1个字节，节省空间。

 */
public class Demo1 {

    public static void main(String[] args) {
//        // byte
//        byte byteVariable = 1;
//
//        // short
//        short shortVariable = 2;
//
//        // int
//        int intVariable = 3;
//
//        // long
//        long longVariable = 4;
//
//
//
//        // 表示二进制
//        System.out.println(0b11);
//
//        // 表示八进制
//        System.out.println(0.1);
//
//        // 十进制
//        System.out.println(11);
//
//        // 十六进制
//        System.out.println(0x11);
//
//
//        // float
//        float floatVariable = 1;
//
//        // double
//        double doubleVariable = 2;
//
//
//        // char
//        char charVariable = 'a';
//
//        // char类型，输出字符
//        System.out.println('a');
//
//        // 让字符参与运算，实际上字符的整数值参与运算
//        System.out.println('a' + 1);

        // boolean
        boolean booleanVariable1 = true;
        boolean booleanVariable2 = false;

    }
}
