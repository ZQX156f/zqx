package com.cskaoyan.object;


import com.cskaoyan.oop.block.ex.Demo;

/*

        public final native Class<?> getClass();
        返回此 Object 的运行时类
        注意： 该方法时一个成员方法
 */
public class Demo2 {

    public static void main(String[] args) {

        TestClass obj = new TestClass();

        // 返回一个Class对象可以表示一个类的信息
        Class aClass = obj.getClass();

        // 获取类的类名
        System.out.println(aClass.getSimpleName());
        // 获取类的全限定类名
        System.out.println(aClass.getName());


        // 可以利用Class判断 对象所属类
        TestClass first = new TestClass();
        TestClass second = new TestClass();

        Class aClass1 = first.getClass();
        Class aClass2 = second.getClass();
        // Class对象是否是同一个对象，即两对象是否是同种类型的对象
        System.out.println(aClass1 == aClass2);

        Demo2 demo2 = new Demo2();
        Class  aClass3 = demo2.getClass();

        // Class对象是否是同一个对象，即两对象是否是同种类型的对象
        System.out.println(aClass3 == aClass1);


        // 创建子类对象获取子类对应的Class对象
        Son son = new Son();
        Class aClass4 = son.getClass();
        System.out.println(aClass4 == aClass1);


        // instanceof
        System.out.println(son instanceof TestClass);
        System.out.println(first instanceof TestClass);
    }
}

class TestClass {

}

class Son extends TestClass {}
