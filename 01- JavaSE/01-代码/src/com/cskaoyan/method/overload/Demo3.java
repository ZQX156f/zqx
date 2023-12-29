package com.cskaoyan.method.overload;

/*
        当发生方法重载的时候，方法调用的问题

 */
public class Demo3 {

    public static void main(String[] args) {
        //test(10);

        // 模糊的方法调用，编译器无法根据就近原则来分辨
        //test(10,10);
    }

    // 方法1
//    public static void test(int a){
//        System.out.println("int");
//    }
    // 方法2
//    public static void test(double a){
//        System.out.println("double");
//    }
    // 方法3
//    public static void test(float a){
//        System.out.println("float");
//    }


    // 方法1
    public static void test(int a,double b){}
    // 方法2
    public static void test(double a,int b){}
}
