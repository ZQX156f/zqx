package com.cskaoyan.exception;


/*
     jvm默认异常处理机制：
      如果错误产生在main方法中
        - 当我们的代码执行到错误行数之前，代码是正常执行的
        - 当我们的代码执行到错误行数时，JVM会终止程序的执行，抛出一个该异常信息封装成的对象
        - 将该对象中的异常信息，打印到控制台上，告诉程序员发生了什么问题
        - 发生错误之后的语句，都不执行了

      如果错误产生在main方法当中的另一个方法中
        - 当程序执行到该方法的错误行数时，JVM会终止程序的执行
          - 向上给方法的调用者抛出一个该异常信息封装成的对象
        - 一直向上抛出，直到抛给main方法，main方法最终抛给JVM
        - 发生异常之前的语句正常执行，但是之后的语句都不执行了


 */
public class Demo1 {

    public static void main(String[] args) {
        System.out.println("main begin");

        // 调用出错的方法
        method();

        System.out.println("after / by zero");
    }


    public static void method() {
        int i = 0;
        // 出现运算错误: 除0异常
        int j = 10 / i;

        System.out.println("hello");
    }
}
