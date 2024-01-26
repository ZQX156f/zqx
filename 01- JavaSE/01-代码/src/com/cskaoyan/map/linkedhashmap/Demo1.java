package com.cskaoyan.map.linkedhashmap;


import java.util.LinkedHashMap;

/*
         LinkedHashMap

 */
public class Demo1 {

    public static void main(String[] args) {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);

        linkedHashMap.put("1", "aaa");
        linkedHashMap.put("2", "ccc");
        linkedHashMap.put("3", "bbb");

        System.out.println(linkedHashMap);
        String s1 = linkedHashMap.get("1");
        System.out.println(linkedHashMap);
    }
}
