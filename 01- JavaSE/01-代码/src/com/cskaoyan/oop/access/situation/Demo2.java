package com.cskaoyan.oop.access.situation;

public class Demo2 {

    public static void main(String[] args) {
        // private修饰了构造方法之后，在其他类中创建对象，访问不到了
        //A a = new A();
        A a = A.getA();
        A a1 = A.getA();

    }
}

class A {


    static A a;

    private A () {

    }

    public static A getA() {

        if (a == null) {
            a = new A();
        }

        return a;
    }


}
