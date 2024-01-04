package com.cskaoyan.oop.single;

public class Demo1 {

    public static void main(String[] args) {


        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        System.out.println(first == second);

    }
}

class Singleton {
    // 提供一个自身类型的静态成员变量
    private static Singleton instance;

    // 构造器私有
    private Singleton() {
    }

    //提供一个静态的方法 , 来返回唯一的这个对象
    public static Singleton getInstance() {
        if (instance == null) {
            // 判断instance是否为null
            instance = new Singleton();

        }

        // 返回唯一的这个对象
        return instance;
    }

}
