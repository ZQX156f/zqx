package com.cskaoyan.oop2.extend.limit;

/*
        继承的限制:
        1. 可以继承私有成员，但无法访问
        2. 父类的构造方法，子类不能继承
        3.
 */
public class Demo1 {

    public static void main(String[] args) {

        System.out.println(LimitSon.staticField);
    }

}

class LimitFaher {

    static double staticField;

    private  int a;

}


class LimitSon extends LimitFaher {


    /*
         访问父类的私有成员
     */
    public void accessPrivate() {

        // 父类的私有成员，没有有访问权限
        // System.out.println(a);
    }
}
