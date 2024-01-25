package com.cskaoyan.map.basic;

import java.util.*;

/*
       // -----特殊方法(在实际使用的时候,主要是用来帮助我们遍历Map数据)-------
    //        Set<K> keySet()
    //        返回此映射中包含的键的 Set 视图。
    //        Collection<V> values()
    //        返回此映射中包含的值的 Collection 视图。
    //        Set<Map.Entry<K,V>> entrySet()
    //        返回此映射中包含的映射关系的 Set 视图。

 */
public class Demo2 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("1", 111);
        map.put("2", 222);
        map.put("3", 333);

        // 1. 遍历map中所有键值对
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
//            System.out.println("key = " + entry.getKey()
//                    + ", value = " + entry.getValue());
        }


        // 2  Set<K> keySet() 返回map所有key的集合
        Set<String> strings = map.keySet();
        Iterator<String> keyIterator = strings.iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = map.get(key);
//            System.out.println("key = " + key
//                    + ", value = " + value);
        }

        //    Collection<V> values()  值的集合
        Collection<Integer> values = map.values();
        for (Integer i : values) {
            System.out.println(i);
        }


    }
}
