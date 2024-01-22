package com.cskaoyan.datastructure.generic.supplement;

/**
 * @author zhangshuai@Cskaoyan.onaliyun.com.
 * @version 1.0
 *
 *    java 语言中的装箱和拆箱
 *
 *基本数据类型      包装类
 *    byte   ——>  Byte
 *    short  ——>  Short
 *    int    ——>  Integer
 *    long   ——>  Long
 *    char   ——>  Character
 *    float  ——>  Float
 *    double ——>  Double
 *    boolean ——> Boolean
 *
 *    一个包装类对象 维护了 一个对应基本类型的数据的 值
 *
 *    装箱和拆箱
 *
 */
public class Demo1 {

  public static void main(String[] args) {

    //举例：int 和 Integer 一个包装类对象 维护了一个对应类型的，基本类型的数据
    //example();

    //自动装箱
    //box();

    //自动拆箱
    //unbox();
  }

  private static void example() {
    // 装箱
    Integer integer = new Integer(1000);


    //Integer integer1 = Integer.valueOf("12");
    //System.out.println(integer1.intValue());

    // 拆箱
    int i = integer.intValue();
    System.out.println(i);
  }
  private static void box() {
    //int a = 100;
    // 装箱  把一个基本数据类型的值 -> 封装到了其包装类的对象
    // 1. 对基本类型的数据，创建一个包装类对象，并且将其对应的基本数据类型的值，封装到该对象中
    // 2.  把自动创建的这个Integer对象的引用，

    //自动装箱
    //Integer aInteger = a; // Integer aIngeger = new Integer(a)
    //System.out.println(aInteger.intValue());

    // 对于取值范围在 -128 - 127 基本数据类型的整数值 他们所对应的 包装类对象
    Integer i1 = 1000; // new Integer(10000)
    Integer i2 = 1000;// new Integer(10000)
    System.out.println(i1 == i2);
  }

  private static void unbox() {
    Integer integerValue = new Integer(1000);

    //System.out.println(integer == integerValue);

    // 自动拆箱
    int c = integerValue; //  int c = integerValue.intvalue();
  }
}
