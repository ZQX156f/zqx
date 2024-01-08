package com.cskaoyan.oop3.abstrcats.basic;


/*
        按照上述构想我们首先把方法的方法体去掉，这样就得到一个抽象方法。它的语法是：
        [修饰符列表] abstract 返回值类型 方法名(形参列表);
        注：
        1. 抽象方法没有方法体，只有方法的声明（方法头）。但是不要忘记写分号";"。
        2. 抽象方法必须写在一个抽象类中。

        接下来，我们定义抽象类。它的语法是：
        [修饰符列表] abstract class 类名{
            //类体
        }

        使用:
          1. 抽象类仍然是一个类，它的命名仍然需要遵循大驼峰的命名规范。当然，它比较特殊，
             许多公司的开发规范中，会要求将抽象类命名为`AbstracXxx`或`BaseXxx`，用于表示该类是一个抽象类。
             这是一个不错的命名习惯，推荐使用，但不强制。

          2.类class在定义时，本身可以使用的修饰符就比较少，除了访问权限修饰符之外，几乎就只有final、abstract等少数修饰符。
            但是final和abstract在修饰类时是冲突的，不能放在一起使用。
            final是阻止继承而abstract是抽象类，如果不继承抽象类没有任何意义。

 */
public class Demo1 {

    public static void main(String[] args) {
        // 抽象類不能直接实例化
        //AbstractClass abstractClass = new AbstractClass();

        // 抽象类可以间接实例化
        AbstractClass father = new AbstractSon();

        // 和多态有联系
        father.test();
    }
}

// 抽象类不能直接实例化
abstract class AbstractClass {
    public abstract void test();
}

// 抽象类可以被继承
class AbstractSon extends AbstractClass {

    /*
        在子类中，覆盖父类的抽象方法，增加方法实现
     */
    @Override
    public void test() {

    }
}
