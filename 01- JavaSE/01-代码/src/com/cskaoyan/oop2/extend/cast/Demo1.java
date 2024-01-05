package com.cskaoyan.oop2.extend.cast;


/*
        引用类型的数据类型转化
        1. 前提: 必须是发生了继承关系的不同类型
        2. 转化的对象:  仅仅只是引用变量的类型

        自动类型转化，无序特殊语法，强制类型转化，使用一下语法完成
        子类类型 子类的对象名 = (子类的类名)父类引用


 */
public class Demo1 {

    public static void main(String[] args) {

        Father father = new Father();
        Son son = new Son();

        // 自动类型转化
        //  is-a的关系
        //  将子类类型的引用变量 ——> 父类类型的引用变量
        father = son;

        // 强制类型转化
        // 将父类类型的引用变量 ——> 子类类型的引用变量
        son = (Son) father; //ClassCastException
        System.out.println(son.j);


    }
}

class Father {
    int i;
}

class Son extends Father {

    int j;
}
