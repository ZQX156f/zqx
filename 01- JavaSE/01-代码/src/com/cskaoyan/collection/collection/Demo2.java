package com.cskaoyan.collection.collection;

import java.util.ArrayList;
import java.util.Collection;

/*

        // -----------辅助方法: size isEmpty, equals, hashCode..--------------
        //        int size()
        //        boolean isEmpty()
        //        boolean equals(Object o): 重写了这个方法, 按照内容进行比较
        //        int hashCode()
        //        void clear()

 */
public class Demo2 {

    public static void main(String[] args) {
      // int size()
      Collection<String> first = new ArrayList<>();
      System.out.println(first.size());

      first.add("1");
      first.add("zs");
      System.out.println(first.size());

      //boolean isEmpty()
        boolean empty = first.isEmpty();
        System.out.println(empty);


        //void clear() 清空容器中的数据
        first.clear();
        System.out.println(first);



    }
}
