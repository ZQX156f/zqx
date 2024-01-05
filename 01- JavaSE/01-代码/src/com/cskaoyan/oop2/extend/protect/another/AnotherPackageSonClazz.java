package com.cskaoyan.oop2.extend.protect.another;

import com.cskaoyan.oop2.extend.protect.one.CurrentClazz;

public class AnotherPackageSonClazz extends CurrentClazz {


    public void access() {

        // 访问继承的protected访问权限的成员
        System.out.println(protectedField);


    }
}
