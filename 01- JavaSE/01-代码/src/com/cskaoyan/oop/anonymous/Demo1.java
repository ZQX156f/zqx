package com.cskaoyan.oop.anonymous;

import com.cskaoyan.oop.keystatic.situation.Demo;

/*
        匿名对象: 没有名字的对象(没有引用变量指向的对象)
        new 类名();

        使用场景：
        1. 方法参数
        2. 方法返回值

        优点：
        1. 代码比较简洁
        2. 可以让堆上的对象，在执行完匿名对象的创建后变成垃圾，理论上可以提高内存利用率

        缺点：
         如果一个对象不止使用一次，就需要创建多个匿名对象

 */
public class Demo1 {

    public static void main(String[] args) {

        Anonymous anonymous = new Anonymous();

        Demo1 demo1 = new Demo1();
        anonymous.testAnonymousArg(demo1);

        // 可以使用匿名对象传递参数
        anonymous.testAnonymousArg(new Demo1());
        anonymous.testAnonymousArg(new Demo1());
        anonymous.testAnonymousArg(new Demo1());

    }
}

class Anonymous {


    /*
         作为方法参数
     */
    public void testAnonymousArg(Demo1 demo) {

    }

    public Demo1 testAnonymousResult() {

        // 匿名对象的第二种使用场景
        return new Demo1();
    }
}
