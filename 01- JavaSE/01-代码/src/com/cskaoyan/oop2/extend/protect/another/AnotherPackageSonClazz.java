package com.cskaoyan.oop2.extend.protect.another;

import com.cskaoyan.oop2.extend.protect.one.CurrentClazz;
import com.cskaoyan.oop2.extend.protect.one.SamePackageAnotherClazz;

public class AnotherPackageSonClazz extends CurrentClazz {


    public void access() {

        // 访问继承的protected访问权限的成员
        System.out.println(this.protectedField);

        // 创建父类对象  访问不到
        CurrentClazz currentClazz = new CurrentClazz();
        // System.out.println(currentClazz.protectedField);

        // 在子类对象上访问
        AnotherPackageSonClazz anotherPackageSonClazz = new AnotherPackageSonClazz();
        System.out.println(anotherPackageSonClazz.protectedField);


        // 访问兄弟中的protected成员 访问不到
        SamePackageAnotherClazz samePackageAnotherClazz
                = new SamePackageAnotherClazz();
        //System.out.println(samePackageAnotherClazz.protectedField);


    }
}
