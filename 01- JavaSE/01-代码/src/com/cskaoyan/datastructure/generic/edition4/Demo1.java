package com.cskaoyan.datastructure.generic.edition4;


/*
     泛型类型，从定义上来讲，只适用于类定义和类体中

 */
public class Demo1 {

    public static void main(String[] args) {

        S0 s0 = new S0();
        // 子类继承父类时，未指定泛型类型，继承泛型类型实际是Object
        s0.ft = new Object();

        S1 s1 = new S1();
        // 子类继承父类时，父类指定了具体的泛型类型，继承的是父类指定的具体类型
        s1.ft = "aaa";

        // 制定了子类的泛型类型
        S2<String> s2 = new S2<>();
        //  父类使用的泛型类型，就是父类指定String类型
        s2.ft = 1;
        // 子类使用的泛型，是创建子类对象时指定的泛型
        s2.e = "aaa";

        // 子类和父类使用相同的泛型类型
        S3<String> stringS3 = new S3<>();
        stringS3.ft = "abc";
        stringS3.e = "abc";

        // 如果父类子类使用相同的泛型类型，指定泛型类型名相同即可
        S4<Integer> objectS4 = new S4<>();
        objectS4.ft = 1;
        objectS4.e = 1;
    }
}

class Father<T> {
    T t;
}

class Son extends Father {

    // 访问不到父类中的泛型类型
    //T t;
    public void access() {
        System.out.println(t);
    }
}

class F <T> {
    T ft;
}
class S0 extends F{}
class S1 extends F<String>{ }
class S2 <E> extends F<Integer>{
    E e;
}
class S3 <E> extends F<E> {
    E e;
}
class S4 <T> extends F<T>{
    T e;
}
