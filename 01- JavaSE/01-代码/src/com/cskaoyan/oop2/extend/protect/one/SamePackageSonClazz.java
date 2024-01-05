package com.cskaoyan.oop2.extend.protect.one;

public class SamePackageSonClazz extends CurrentClazz{



    public void access () {


        System.out.println(protectedField);

        CurrentClazz currentClazz = new CurrentClazz();
        // 同包非子类
        System.out.println(currentClazz.protectedField);

    }
}
