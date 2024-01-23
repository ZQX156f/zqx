package com.cskaoyan.datastructure.generic.edition2;

/*

      泛型使用的语法
 */
public class Demo1 {

    public static void main(String[] args) {
        // 指定参数类型
        // jdk6及以前的用法
        Person<String> objectPerson = new Person<String>();

        // jdk7及以后
        Person<Integer> intPerson = new Person<>();

        // 不指定类型, 使用的实际类型就变成了Object类型
        Person objectPerson1 = new Person();
        //
        objectPerson1.t = new Object();

    }
}

class Person<T> {
    T t;
}
