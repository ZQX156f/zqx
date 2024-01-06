package com.cskaoyan.oop2.extend.override.ex;

public class Demo {
    public static void main(String[] args) {
        Son s = new Son();  //0
        Son s2 = new Son(300); // 0
        Father fs = new Son(); // 0
        Father f = new Father(); // 100
    }
}

class Father {
    int num = 100;

    public int getNum() {
        return num;
    }

    public Father() {
        // 该行在执行时,如果创建的是子类对象,
        // 那么子类的任何赋值手段都没有执行,那子类中的num一定是0
        System.out.println(getNum());
    }

}

class Son extends Father {
    int num = 200;

    @Override
    public int getNum() {
        return num;
    }

    public Son() {
        super();
    }

    public Son(int num) {
        this.num = num;
    }
}
