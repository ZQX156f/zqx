package com.cskaoyan.oop2.extend.protect.another;

import com.cskaoyan.oop2.extend.protect.one.CurrentClazz;
import com.cskaoyan.oop2.extend.protect.one.SamePackageSonClazz;

public class AnotherPackageAnotherClazz {

    public static void main(String[] args) {

        CurrentClazz currentClazz = new CurrentClazz();

        // 非同包非子类中无法访问 protected访问权限的成员
        //System.out.println( currentClazz.protectedField);

    }
}
