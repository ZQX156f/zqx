package com.cskaoyan.oop.keystatic.method;

/*
        静态方法:
          [访问权限修饰符] static 返回值类型 方法名(形参列表){
                //方法体
          }

       使用与特征:
       1. 无需创建对象就可以直接通过类名点直接调用。
       2. 同一个类中的static方法互相调用可以省略类名，直接用方法名调用
 */
public class Demo1 {

    public static void main(String[] args) {

        // 静态方法的访问，可以桶过类名.的方式访问
        TestStaticMethod.staticMethod(10);

        // 测试同一个类中的静态方法的调用
        //TestStaticMethod.secondStaticMethod();


        // 还可以通过对象名.的方式访问静态方法
        //TestStaticMethod obj = new TestStaticMethod();
        //obj.staticMethod(10);

    }
}

class TestStaticMethod {

    int j;

    public void method() {
        System.out.println("method" + this.j);
    }

    public static void staticMethod(int i) {
        // 静态方法中不能访问普通成员变量的值
        // System.out.println(this.j);

        // 静态方法中不能访问非静态的成员方法
        // method();
        System.out.println("static method " + i);
    }

    public static void secondStaticMethod() {
        System.out.println("second static");
         // 调用同一个类中的其他静态方法
        staticMethod(10);
    }

}
