package com.cskaoyan.exception;

import java.io.FileNotFoundException;

/*
            在方法定义时使用
                声明该方法可能抛出的异常
                对于编译时异常，可以在语法层面强制方法调用者处理该异常

            修饰符  返回值 方法名(形参列表)  throws 异常列表 {}

        1. 异常列表: 异常类型1, 异常类型2, .... 用逗号隔开，列表中的异常不要出现父子关系，如果有，那么编译器只会强制处理父类
        2. 只是声明可能抛出,到底抛不抛,看代码
        3. throws+运行时异常没有意义,因为运行时异常会自动抛出,不需要声明.throws+编译时异常才有意义,这实际上是编译异常处理的一种方式
        4. 在方法中声明throws+编译时异常,声明可能抛出编译时异常,该方法被调用时就要处理这个编译异常
        5. 处理编译时异常
          - 方法内部try-catch
          - throws向上抛,如果在main中就别抛了,处理一下

 */
public class Demo4 implements Cloneable {

    public static void main(String[] args) {


        try {
            checkMethod();
        } catch (Exception e) {
           e.printStackTrace();
        }

        // 调用 throws 声明的运行时异常的方法
        testThrowsRuntime();


    }



    /*
          产生运行时异常
     */
    public static int runtimeMethod() {
        int j = 0;
        return 10 / j;
    }

    /*
         产生编译时异常
     */
    public static void checkMethod() throws CloneNotSupportedException, FileNotFoundException, Exception {

        Demo4 demo4 = new Demo4();

        // 可能会产生 编译时异常
        demo4.clone();
    }

    public static void testThrowsRuntime() throws NullPointerException {

    }



}
