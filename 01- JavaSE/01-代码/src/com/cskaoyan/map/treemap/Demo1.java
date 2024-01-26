package com.cskaoyan.map.treemap;


import java.util.Comparator;
import java.util.TreeMap;

/*
     treeMap:
     // 1, TreeMap是Map接口子实现
    // 2, TreeMap数据结构表现是红黑树 (key有序，大小有序)
    // 3, TreeMap存储数据大小有序
    // 4, TreeMap不允许存储重复数据  (什么叫重复?  key的大小一样)
    // 5, TreeMap不允许null作为key
    // 6, TreeMap线程不安全

    TreeMap()
     使用键的自然顺序构造一个新的、空的树映射。
    TreeMap(Comparator<? super K> comparator)
         构造一个新的、空的树映射，该映射根据给定比较器进行排序。


         //  -----Map接口定义的api---------

// ------自己的新的关于大小操作的api---------------------

//        Map.Entry<K,V> ceilingEntry(K key): 返回大于等于给定值的键值对
//        K ceilingKey(K key): 返回大于等于给定值的key
//        Map.Entry<K,V> floorEntry(K key): 返回小于等于给定值的键值对
//        K floorKey(K key): 返回小于等于给定值的key
//        Map.Entry<K,V> higherEntry(K key): 返回大于给定值的键值对
//        K higherKey(K key): 返回大于给定值的key
//        Map.Entry<K,V> lowerEntry(K key): 返回小于给定值的键值对
//        K lowerKey(K key): 返回小于给定值的key

//        Map.Entry<K,V> firstEntry(): 获得第一份键值对()最小
//        K firstKey(): 获得第一份key()最小
//        Map.Entry<K,V> lastEntry(): 获得最后一份键值对(最大)
//        K lastKey(): 获得最后一份key(最大)
//        Map.Entry<K,V> pollFirstEntry(): 删除第一份数据(最小)
//        Map.Entry<K,V> pollLastEntry(): 删除最后一份数据(最大)


//        NavigableSet<K> navigableKeySet()
//        返回此映射中所包含键的 NavigableSet 视图。
//        如果此映射为指定值映射一个或多个键，则返回 true。
//        NavigableSet<K> descendingKeySet()
//        返回此映射中所包含键的逆序 NavigableSet 视图。
//        NavigableMap<K,V> descendingMap()
//        返回此映射中所包含映射关系的逆序视图。


//        NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
//        返回此映射的部分视图，其键的范围从 fromKey 到 toKey。
//        SortedMap<K,V> subMap(K fromKey, K toKey)
//        返回此映射的部分视图，其键值的范围从 fromKey（包括）到 toKey（不包括）。
//        SortedMap<K,V> tailMap(K fromKey)
//        返回此映射的部分视图，其键大于等于 fromKey。
//        NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
//        返回此映射的部分视图，其键大于（或等于，如果 inclusive 为 true）fromKey。
//        SortedMap<K,V> headMap(K toKey)
//        返回此映射的部分视图，其键值严格小于 toKey。
//        NavigableMap<K,V> headMap(K toKey, boolean inclusive)
//        返回此映射的部分视图，其键小于（或等于，如果 inclusive 为 true）toKey。
 */
public class Demo1 {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        // 可以比较大小的key
        treeMap.put("abc", 1);

        User zs = new User("zs", 18);
        TreeMap<User, String> secondMap = new TreeMap<>();
        // key 必须是可比较的
        //secondMap.put(zs, "111");

        // key key 课比较

        // TreeMap(Comparator<? super K> comparator)

        MyComparator myComparator = new MyComparator();
        TreeMap<User, Integer> thirdMap = new TreeMap<>(myComparator);

        User lisi = new User("lisi", 18);
        thirdMap.put(lisi, 20);

    }
}

/*
     比较器
 */
class MyComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.name.compareTo(o2.name);
    }
}

//class User implements Comparable<User> {
//
//    String name;
//    int age;
//
//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(User o) {
//
//        return name.compareTo(o.name);
//    }
//}

class User {


    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
