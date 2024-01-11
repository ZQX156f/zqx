package com.cskaoyan.io.bytestream.output;

import java.io.*;

/*
        1. 当我们创建一个FileOutputStream对象的时候,发生了什么?
            - jvm向操作系统中看这个文件是否存在
            - 如果文件不存在, 帮我们创建
            - 文件已经存在, 覆盖重新开始写  因为默认向文件中写入数据的方式是从文件头开始写入

        2. 如何实现文件追加功能?
        FileOutputStream(File file,  boolean append)
        创建一个向指定 File  对象表示的文件中写入数据的文件输出流。

        FileOutputStream(String name,  boolean append)
         创建一个向具有指定 name 的文件中写入数据的输出文件流 append - 如果为 true，
         则将字节写入文件末尾处，而不是写入文件开始处

       3.如何实现换行功能
          不同的操作系统，换行符
          a. 类unix操作系统  换行符 '\n'
          b. windows操作系统  换行符 "\r\n"

       4. 异常处理的问题
       语法
        try(资源,只要实现了AutoCloseable接口的类){
         //可能出现异常的代码
         // 当出了try代码块的时候 close方法会自动执行 资源会被自动释放
        }catch(){

        }

       5. 为什么要close?
        - jvm使用了不属于jvm的资源, 不能通过GC回收, 只能通过close显式的释放资源.



 */
public class Demo3 {

    public static void main(String[] args) {
        // 演示前三个问题的代码
        //firstThreeQuestion();

        // 基本的异常处理
        // basicIOExceptionHandle();

//        try (A a = new A()) {
//            // 调用func 不调用close
//            a.func();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (OutputStream os = new FileOutputStream("d:\\a.txt"))  {
            // 1. 创建流对象

            // 2. 向文件中写入数据
            os.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void basicIOExceptionHandle() {
        OutputStream os = null;
        try {
            // 1. 创建流对象
            os = new FileOutputStream("e:\\a.txt");

            // 2. 向文件中写入数据
            os.write("hello".getBytes());


        } catch (IOException e) {
           e.printStackTrace();
        } finally {

            // 3. 释放资源
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void firstThreeQuestion() throws IOException {
        // 创建FileOutputStream对象
        // FileOutputStream(File file,  boolean append)
        OutputStream os = new FileOutputStream("a.txt", true);

        // 获取当前操作系统中默认的换行符
        String lineSeparator = System.lineSeparator();
        //System.out.println("\r\n".equals(lineSeparator));

        // 换行写入
        os.write(lineSeparator.getBytes());


        byte[] data = {'a', 'b', 'c'};
        // 写入数据
        os.write(data);


        // 释放系统资源
        os.close();
    }
}

class A implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("close执行了");
    }

    public void func(){
        System.out.println("func方法执行了");
    }
}
