package com.cskaoyan.method.overload;

/*
       一个类中的多个方法，可以具有相同的方法名，但是它们的形参列表必须不同。

        形参列表不同意味着：
        1. 形参数量不同
        2. 形参数量相同时，形参的数据类型不同
        3. 形参数量和数据类型都相同时，形参的数据类型的顺序不同


        除开上述条件外，其余的任何不同都无法构成方法重载，经典的错误有：
            1. 形参的名字不同，可以构成方法重载
            2. 返回值类型不同，可以构成方法重载
            3. 修饰符列表不同，可以构成方法重载
 */
public class Demo2 {


//    方法的修饰符并不能影响方法重载的结果
//    protected static void test() {
//
//    }
    public static void test(int a) {

    }

//    参数名称并不影响，方法重载的结果
//    public void test(int b) {
//
//    }
    public static void test() {

    }
//    方法返回值并不影响方法重载的结果
//    public static int test() {
//        return 1;
//    }



    public static void test(String s) {

    }

    // 类型顺序顺序不同
    public static void test(int a, String b) {

    }

    public static void test(String a, int b) {

    }
}
