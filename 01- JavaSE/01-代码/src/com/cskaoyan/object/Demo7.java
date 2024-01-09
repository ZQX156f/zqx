package com.cskaoyan.object;

/*
        演示空接口的标记作用
 */
public class Demo7 {

    public static void main(String[] args) {
        judgeInstanceImplEmptyInter(new A());
    }

    //用于判断传入的对象是否是接口的子类对象
    public static void judgeInstanceImplEmptyInter(Object o) {
        if (o instanceof EmptyInterface) {
            System.out.println("实现了空接口,可以做一些操作");
            return;
        }
        System.out.println("没有实现空接口,抛出异常");
    }
}

interface EmptyInterface {
}

class AA implements EmptyInterface {
}


