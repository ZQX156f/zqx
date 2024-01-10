package com.cskaoyan.exception;


import java.io.FileNotFoundException;

/*
        异常列表对方法覆盖条件的影响
        1. 异常列表只包含运行时异常，不会影响方法覆盖的条件
        2. 否则，方法覆盖的条件，会受到影响
            - 子类方法抛出的异常类型必须和父类方法抛出的异常类型兼容
            - 子类方法可以没有异常列表
            - 建议子类重写的时候保持跟父类一样的异常列表
 */
public class Demo5 {

    public static void main(String[] args) {

    }
}

class ThrowsFather {


    /*
         编译时异常
     */
    public void checkMethod() throws Exception {

    }


    /*
        运行时异常
     */
    public void runtimeMethod() throws ArrayIndexOutOfBoundsException {

    }


}

class ThrowsSon extends ThrowsFather {


    /*
     编译时异常
 */
    @Override
    public void checkMethod() throws FileNotFoundException, CloneNotSupportedException  {

    }


    /*
        运行时异常
     */
    @Override
    public void runtimeMethod() throws NullPointerException {

    }

}