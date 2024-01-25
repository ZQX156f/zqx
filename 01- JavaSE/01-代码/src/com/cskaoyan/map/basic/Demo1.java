package com.cskaoyan.map.basic;

import java.util.HashMap;
import java.util.Map;

/*
        Map的api

 // ----添加删除相关----------------
//        V put(K key, V value): 添加方法
//        void putAll(Map<? extends K,? extends V> m): 添加所有
//        V remove(Object key): 根据key删除键值对
//        V get(Object key): 根据key获取key对应value
//        boolean containsKey(Object key): 查找key是否存在
//        boolean containsValue(Object value): 查找value是否存在
   // -----辅助方法------------------
//        int size()
//        返回此映射中的键-值映射关系数。
//        int hashCode()
//        返回此映射的哈希码值。
//        boolean isEmpty()
//        如果此映射未包含键-值映射关系，则返回 true。
//        boolean equals(Object o)
//        比较指定的对象与此映射是否相等。
//        void clear()
//        从此映射中移除所有映射关系（可选操作）。


 */
public class Demo1 {

    public static void main(String[] args) {
        // 创建map对象
        Map<String, Integer> map = new HashMap<>();

        // V put(K key, V value): 添加方法
        map.put("first", 1);

        //  V get(Object key): 根据key获取key对应value
        Integer i = map.get("first");
        //System.out.println(i);

        // V remove(Object key): 根据key删除键值对
        //map.remove("first");

        Integer i1 = map.get("first");
        //System.out.println(i1);

        //        boolean containsKey(Object key): 查找key是否存在
        //        boolean containsValue(Object value): 查找value是否存在

        boolean b = map.containsKey("first");
        //System.out.println(b);

        boolean b1 = map.containsValue(1);
        //System.out.println(b1);

        //void putAll(Map<? extends K,? extends V> m): 添加所有

        HashMap<String, Integer> secondMap = new HashMap<>();
        secondMap.put("second", 2);
        secondMap.put("third", 3);

        map.putAll(secondMap);

        Integer i2 = map.get("second");
        System.out.println(i2);

        System.out.println(map);

        // int size()
        int size = map.size();
        System.out.println(size);


    }
}
