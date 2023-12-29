package com.cskaoyan.method.basic;

/*

            [修饰符列表] 返回值类型 方法名 (形式参数列表){
	        // 方法体

            }
 */
public class Demo1 {

    public static void main(String[] args) {

    }


    // 有返回值的方法
   public static  int addInt(int a, int b) {
       int c = a + b;
       return c;
   }

   // 没有返回值的方法
   public static void print(int a) {
       System.out.print(a);
   }

}
