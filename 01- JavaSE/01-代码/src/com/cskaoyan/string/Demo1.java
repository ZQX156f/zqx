package com.cskaoyan.string;



/*

   String
    - 一个字符串是由多个字符组成的一串数据(字符序列,字符数组)
    - String类代表字符串,Java 程序中的所有字符串字面值（如 "abc" ,"你好","の"）都作为此类的实例实现
    - 在java.lang包下,是java核心类,最常用类,但是不属于基本数据类型,引用类型
    - String类提供了字符串表示、比较、查找、截取、大小写转换等各种针对字符串的操作


       String类的构造方法:
         //空字符串 ""
  public String()

  //利用字节数组，创建字节数组所表示的字符串
  // 1. 字符 -> 数值形式  'a' -> 97
  // 2. 所以可以用多个字节值，表示多个字符——>即字符序列 public
  String(byte[] bytes)

  //利用字节数数组的一部分，创建字符序列, 从byte数组的offset开始的length个字节值
  public String(byte[] bytes,int offset,int length)

  //利用一个字符数组创建字符数组，代表的字符序列
  public String(char[] value)

  // 创建value字符数组中，从第offset位置开始的count个字符，所代表的字符串对象
  public String(char[] value,int offset,int count)

  //知道即可
  public String(String original)
 */
public class Demo1 {

    public static void main(String[] args) {

        String s = null;

        // public String() 空字符串 ""
        s = new String();
        // 获取字符串中包含的字符个数
//        System.out.println(s.length()); // 0
//        System.out.println(s.isEmpty()); // true

        // 空字符串不是null
        String nullStr = null;
//        null 空指针异常
//        System.out.println(nullStr.length());
//        System.out.println(nullStr.isEmpty());

        //   String(byte[] bytes)
        //              'a' 'b' 'c' 'd'  'e'
        byte[] bytes = {97, 98, 99, 100, 101};
        s = new String(bytes);
        //System.out.println(s);

        // public String(byte[] bytes,int offset,int length)
        s = new String(bytes, 2, 3);
        //System.out.println(s);


        // public String(char[] value)
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        s = new String(chars);
        //System.out.println(s);

        // public String(char[] value,int offset,int count)
        s = new String(chars, 0, 3);
        //System.out.println(s);

        // public String(String original)
        String a = "hello";
        s = new String(a);
        System.out.println(s);
        // 比较字符串的内容
        System.out.println(s.equals(a));
        System.out.println(s == a);


    }
}
