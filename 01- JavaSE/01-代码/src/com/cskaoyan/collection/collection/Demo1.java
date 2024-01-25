package com.cskaoyan.collection.collection;

import java.util.ArrayList;
import java.util.Collection;

/*

     Collection接口: 数据增删改查

     //        boolean add(E e): 添加方法
    //        boolean addAll(Collection<? extends E> c): 添加所有
    //        boolean remove(Object o): 根据内容删除
    //        boolean removeAll(Collection<?> c): 删除所有匹配数据
    //        boolean contains(Object o): 查找
    //        boolean containsAll(Collection<?> c): 查找是否都存在
    //        boolean retainAll(Collection<?> c): 保留匹配数据
 */
public class Demo1 {

    public static void main(String[] args) {

        // 父类引用指向子类对象，演示Collection接口中的方法
        Collection<String> c = new ArrayList<>();


        // boolean add(E e): 添加方法
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        c.add("e");

        //boolean remove(Object o)
        c.remove("a");

        // boolean contains(Object o): 查找
        boolean contains = c.contains("b");
        System.out.println(contains);
        contains = c.contains("a");
        System.out.println(contains);


        // 创建第二个Collection数据容器对象
        Collection<String> first = new ArrayList<>();
        //boolean addAll(Collection<? extends E> c): 添加所有
        first.addAll(c);
        System.out.println(first);

        //boolean removeAll(Collection<?> c): 删除所有匹配数据
        Collection<String> second = new ArrayList<>();
        second.add("1");
        second.add("2");
        second.add("b");
        second.add("c");

       // boolean b = second.removeAll(first);
       // System.out.println(second);
       // System.out.println(b);


        // boolean retainAll(Collection<?> c): 保留匹配数据
        Collection<String> third = new ArrayList<>();
        third.add("1");

        second.retainAll(third);
        System.out.println(second);
    }
}
