package com.cskaoyan.map.hashmap;

import java.util.HashMap;
import java.util.Objects;

/*
         loadfactor
        // 1, HashMap是Map接口的子实现
        // 2, HashMap的底层结构:  数组+链表+红黑树(红黑树是在Jdk1.8时候引入的结构)
        // 3, 数组的默认初始长度16,  扩容机制2倍, 加载因子默认是0.75
        // 4, HashMap存储数据无序
        // 5, HashMap不允许存储重复的key (什么叫重复? )
        // 6, HashMap允许存储null作为key
        // 7, 线程不安全
        ArrayDeque & tail = (tail + 1) & (elements.length -1)   %

        // i hash映射的结果
        //  hash % table.length
        // n 等于hash表对应的数组长度
        i = (n - 1) & hash


        hash & (oldn - 1)

        hash & (newn - 1)


        hash:    x1xxxx xxxxxx
                 010000 000000
        oldn     001111 111111 00xxxx xxxxxx  00xxxx xxxxxx i
                                            + 010000 000000
        newn:    011111 111111 00xxxx xxxxxx  01xxxx xxxxxx

 */
public class Demo1 {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("a", 1);

        HashMap<String, String> firstMap = new HashMap<>(10);

        HashMap<User, String> secondMap = new HashMap<>();

        User firstUser = new User("zs", 18);
        User secondUser = new User("zs", 18);

        //     if (p.hash == hash &&
        //                ((k = p.key) == key || (key != null && key.equals(k))))
        secondMap.put(firstUser, "1");
        secondMap.put(secondUser, "2");

    }
}

class User {

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
