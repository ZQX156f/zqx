package com.cskaoyan.exception;

/*
        自定义异常：
        1. 自定义编译时异常
        2. 自定义运行时异常

        实现:
        1. 自己定义类 extends Exception 自定义编译时异常
        2. 自己定义类 extends RuntimeException 自定义运行时异常

        自定义异常只能由我们来抛出

        自定义异常的意义： 在定义

 */
public class Demo8 {

    public static void main(String[] args) throws MyCheckableException {

        //throw new MyRuntimeException("自定义运行时异常");

        throw new MyCheckableException("自定义编译时异常");

    }
}

class MyRuntimeException extends RuntimeException {

    public MyRuntimeException(String message) {
        // message 就变成了我们自定义的异常描述字符串
        super(message);
    }
}

class MyCheckableException extends Exception {

    public MyCheckableException(String message) {
        // 自定义异常描述字符串
        super(message);
    }
}
