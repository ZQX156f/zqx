package com.cskaoyan.datastructure.generic.edition4;


/*
     泛型类型，从定义上来讲，只适用于类定义和类体中

 */
public class Demo1 {
}

class Father<T> {
    T t;
}

class Son extends Father<String> {
    public void access() {
        System.out.println(t);
    }
}
