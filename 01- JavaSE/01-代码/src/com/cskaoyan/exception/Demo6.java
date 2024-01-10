package com.cskaoyan.exception;


/*
        throw关键字
        1.在方法体中使用
        2.主动在程序中抛出异常
        3.每次只能抛出确定的某个异常对象


        注意:
        1. throw运行特征，运行throw语句之后，它之后的代码不会执行
        2. throw+编译时异常,需要结合throws关键字

 */
public class Demo6 {

    public static void main(String[] args) {
        record(-1);
    }



    /*
         向学生管理系统中，录入学生的考试分数[0-100]
     */
    public static void record(int score) throws Exception {

        if (score < 0 || score > 100) {
            // 不正常的分数
            // 创建异常对象
            // RuntimeException 构造方法中的参数 表示异常描述字符串
            //RuntimeException runtimeException = new RuntimeException("分数非法！");

            // 异常对象的抛出
            //throw runtimeException;

            Exception exception = new Exception("非法分数！");
            throw exception;
        }

        // throw 语句执行，之后代码都不会执行(方法执行结束)
        System.out.println("录入分数");
    }
}



