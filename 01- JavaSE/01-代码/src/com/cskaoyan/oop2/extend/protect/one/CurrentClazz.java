package com.cskaoyan.oop2.extend.protect.one;

public class CurrentClazz {

    protected int protectedField;


    public void access () {

        // 同一个类的类体中可以访问
        System.out.println(protectedField);
    }


}
