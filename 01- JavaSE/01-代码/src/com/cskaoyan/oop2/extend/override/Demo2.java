package com.cskaoyan.oop2.extend.override;


/*
     方法覆盖的条件
     // 成员方法的语法
        [访问权限修饰符] 返回值类型 方法名(形参列表){
         //方法体
        }

     1. 子类中重写的方法，访问权限等级，必须至少保持一致，可以更为宽松，但一定不能更严格。

     2. 子类中重写的方法，返回值类型必须和原先父类方法的返回值类型，保持兼容。
         a. 基本数据类型的返回值，此时子类方法返回值 必须和父类方法一样
         b. 引用类型的数据(对象)
            1) 一样 可以发生方法覆盖
            2) 子类方法返回的对象类型 是父类方法返回值的子类类型 即可

     3. 子类中重写的方法，方法名必须严格保持一致，不能做任何修改。

     4. 子类中重写的方法，形参列表必须保持严格一致，不能做任何修改。


    注意事项:
     1. 父类中私有方法不能被重写（因为没有权限访问，更不谈重写）
     2. 静态方法在使用现象上，很像是被重写了，但实际上静态方法不能被重写，而是直接是一个新的静态成员。（使用`@Override`注解标记会报错）
     3. 构造器不能继承，更不能被重写。


 */
public class Demo2 {
}

class ConditionFather {


    void accessMethod() {

    }
//
//    public int intReturnMethod() {
//
//        return 0;
//    }
//
//    public ConditionFather referenceReturnMethod() {
//
//        return null;
//    }
//

//    private void privateMethod() {
//
//    }



    public static void staticMethod() {

    }

}

class ConditionSon extends ConditionFather {

//    如果要发生方法覆盖，子类方法的访问权限 >= 父类方法的访问权限
//   private void accessMethod() {
//
//   }


//    @Override
//    public int  intReturnMethod() {
//
//        return 0;
//    }


    // 返回父类方法返回值的子类类型
//    @Override
//    public ConditionSon referenceReturnMethod() {
//
//        return null;
//    }


    // Override是在向编译器声明，该方法一定覆盖了父类中的方法
    // 父类的private方法不能被覆盖
//    @Override
//    private void privateMethod() {
//
//    }

    // @Override
    public static void staticMethod() {

    }
}
