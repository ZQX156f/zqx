package com.cskaoyan.oop2.ploymorphism;

/*

 */
public class Demo2 {

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        Grandson grandson = new Grandson();

        // 向上转型
        father = grandson;

        // 向下转型 (没问题)
        son = (Son) father;

        // 向下转型 (没问题)
        Grandson g = (Grandson) son;


        // 错误的向下转型
        Father f = new Father();
        // 向下转型 （错误）
        Grandson s = (Grandson) f;


    }
}

class Father{}
class Son extends Father{}
class Grandson extends Son{}
