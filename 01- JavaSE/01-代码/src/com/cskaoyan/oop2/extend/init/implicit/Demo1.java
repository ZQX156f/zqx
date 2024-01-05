package com.cskaoyan.oop2.extend.init.implicit;


/*
      子类对象的隐式初始化: jvm自动先调用父类构造方法，在执行子类构造方法

      隐式对象初始化的必要条件：
        1. 父类中有默认的构造方法
        2. 子类的构造器中没有显式使用super调用父类的构造方法。
 */
public class Demo1 {

    public static void main(String[] args) {

        ImplicitSon implicitSon = new ImplicitSon(10);

        System.out.println(implicitSon.j);
    }


}

class ImplicitFather {

    int i;

//    public ImplicitFather() {
//        System.out.println("ImplicitFather");
//    }

    public ImplicitFather(int i) {
        this.i = i;
    }
}

class ImplicitSon extends ImplicitFather {

    int j;

    public ImplicitSon(int j) {
        //
        this.j = j;
    }
}
