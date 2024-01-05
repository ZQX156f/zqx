package com.cskaoyan.oop2.extend.protect.one;

/*
      同包非子类
 */
public class SamePackageAnotherClazz {


    public void access () {
        CurrentClazz currentClazz = new CurrentClazz();
        // 同包非子类
        System.out.println(currentClazz.protectedField);

    }
}
