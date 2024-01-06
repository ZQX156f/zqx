package com.cskaoyan.oop2.extend.keyfinal;

/*
     final修饰类
         final修饰类时，表示最后的类，最终的类。即表示这个类不能被继承。

     final修饰方法
       final修饰方法表示最后的方法，最终的方法，表示该方法无法被重写
    并不是随便拿一个方法都能用final修饰的，比如：
    1. private方法，本来就无法重写，不需要多此一举。（可以修饰，但是会报警告）
    2. static方法，本来就无法重写，不需要多此一举。（可以修饰，但是会报警告）
    3. 构造方法，不能被继承，更不能重写，加final修饰会编译报错。

     final修饰变量:
      1. 修饰局部变量:  局部变量一旦被赋值，其值就不能在被修改
      2. 修饰成员变量:  保证在对象创建完毕之前，给final修饰的成员变量赋一次初值，之后
                     其值也不能发生变化
      3. 形式静态成员变量:  该变量的值在类加载完成之前，必须赋一次初值，该值全局都不会发生改变
      4. final 类名 对象名 = new 类名(参数); 只是引用变量的值不能变
      final new Student(); 非法


 */
public class Demo1 {
}

class TestFinalVariable {

    // final 修饰成员变量
    final double doubleField;


    public static final int firstStatic = 1;
    public final static int secondStatic;
    static {
        secondStatic = 200;
    }

//    {
//        doubleField = 100;
//    }


    public TestFinalVariable() {
        doubleField = 100;
    }

    public TestFinalVariable(int a) {
        doubleField = 900;
        // 想用构造方法给fnal成员变量赋初值，
        // 必须保证，每一个构造方法中，必须给final修饰的成员变量赋一次值
    }

    public void localMethod(final int b) {

        // 不能修改final修饰的形式参数的值
        //b = 10;

        // 定义定义自定义常量
        final int a = 1;
        // 不能在修改了
        //a = 20;

    }


    public void testFinalReference() {

        final FinalFather finalFather = new FinalFather();

        FinalFather f = new FinalFather();

        // 引用变量的值不能变化
        //finalFather = f;

        finalFather.i = 100;
        finalFather.i = 1000;

        // final不能修饰匿名对象
        //final new FinalFather();
    }


}

// final修饰的类不能被继承
//final class A {}
//class B extends A {}

class FinalFather {

    int i;

//    构造方法不能用final修饰
//    public final FinalFather() {
//    }

    public final void testFinalMethod() {

    }

}

class FinalSon extends FinalFather {

//    @Override
//    public void testFinalMethod() {
//
//    }

}
