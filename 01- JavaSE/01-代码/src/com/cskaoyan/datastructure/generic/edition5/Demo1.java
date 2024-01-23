package com.cskaoyan.datastructure.generic.edition5;


/*
      接口泛型
 */
public class Demo1 {

    public static void main(String[] args) {
        S3<String> s3 = new S3();
        String aaa = s3.getData("aaa");
    }
}

interface F<T>{
    public T getData(T t);
}

/*
    父接口未指定泛型类型，子类中泛型类型默认Object
 */
class S1 implements F{
    @Override
    public Object getData(Object o) {
        return null;
    }
}

/*
     父接口制定了泛型类型，子类使用父接口指定的泛型类型
 */
class S2 implements F<String>{
    @Override
    public String getData(String s) {
        return null;
    }
}
class S3<E> implements F<E>{
    @Override
    public E getData(E e) {
        return null;
    }
}
class S4<T> implements F<T>{
    @Override
    public T getData(T t) {
        return null;
    }
}
