package com.cskaoyan.exception;

/*
        try{
           // 可能出现异常的代码
        }catch(异常类型 对象名){
           // 对异常的处理操作
        }

        方式二:
        try{
           // 可能出现异常的代码
        }catch(异常类型1 | 异常类型2 | 异常类型3 | 对象名){
           // 对异常的处理操作
        }

         try-catch的执行：
        1. 如果try中代码运行时发生了错误，jvm在发生错误的代码处，收集错误信息
        2. try 块中在错误代码之后的代码，就不会在运行，jvm会跳转到相应的错误处理器中，
           执行开发者自己写的，错误处理代码
        3. 错误处理器中的代码，一旦执行完毕紧接着，程序继续正常执行，执行的是整个try代码块之后的代码

        访问JVM创建的异常对象，获取实际发生的异常信息:
        //获取异常信息，返回字符串。
        getMessage()
        //获取异常类名和异常信息，返回字符串。
        toString()
        //获取异常类名和异常信息，以及异常出现在程序中的位置,并打印到控制台
        printStackTrace()

 */
public class Demo2 {

    public static void main(String[] args) {

        // 演示简单地try-catch代码块的使用
        // simpleTryCatch();

        //System.out.println("hello");
        // 同时处理多种不同类型的异常
        try {

            // 除0错误
            //int i = 1 / 0;

            int[] ints = new int[3];
            // 数组越界
            //System.out.println(ints[3]);

            ints = null;
            // 空指针
            System.out.println(ints[0]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {

            System.out.println("发生了异常");
            //e.printStackTrace();
        }

    }

    private static void simpleTryCatch() {
        try {
            int i = 0;
            // 出现运算错误: 除0异常
            int j = 10 / i;

            // 异常之后的代码
            System.out.println("after / by zero");

        } catch (Exception e) {
            // getMessage() / by zero
            String message = e.getMessage();


            //获取异常类名和异常信息，返回字符串。
            //toString()
            // java.lang.ArithmeticException: / by zero
            String string = e.toString();



            //printStackTrace()
            e.printStackTrace();


            //System.out.println(string);
            // 写错误处理的代码
            //System.out.println("发生了错误");
        }
    }
}
