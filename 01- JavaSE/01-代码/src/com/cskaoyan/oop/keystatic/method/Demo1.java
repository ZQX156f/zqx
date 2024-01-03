package com.cskaoyan.oop.keystatic.method;

/*
        静态方法:
          [访问权限修饰符] static 返回值类型 方法名(形参列表){
                //方法体
          }

       使用与特征:
       1. 无需创建对象就可以直接通过类名点直接调用。
       2. 同一个类中的static方法互相调用可以省略类名，直接用方法名调用
       3. 一个类中，静态方法无法直接调用非静态的方法和属性，也不能使用this，super关键字（super后面会讲）,静态的方法只能访问静态的
       4. 经典错误：Non-static field/method xxx cannot be referenced from a static context
       5. 原因：静态方法调用的时候，完全有可能没有对象，没有对象普通成员就无法访问。
       6. 普通成员方法当中，既可以访问静态成员的, 也可以访问非静态成员。普通成员方法访问任意的
       7. 访问静态成员变量的时候，使用类名.变量名的形式访问，以示区别，增加代码可读性
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

    static double staticField;

    public void method() {
        System.out.println("method" + this.j);

        // 可以访问静态成员变量
        System.out.println(staticField);

        // 可以访问静态方法
        staticMethod(10);

    }

    public static void staticMethod(int i) {
        // 静态方法中不能访问普通成员变量的值
        //System.out.println(this.j);

        // 静态方法中不能访问非静态的成员方法
        // method();

        //
        TestStaticMethod testStaticMethod = new TestStaticMethod();
        // 访问已经存在的对象非静态成员变量
        System.out.println(testStaticMethod.j);

        // 访问已经存在的对象的普通成员方法
        testStaticMethod.method();
        System.out.println("static method " + i);
    }

    public static void secondStaticMethod() {
        System.out.println("second static");
         // 调用同一个类中的其他静态方法
        staticMethod(10);

        // 可以访问静态成员变量
        System.out.println(staticField);
    }

}
