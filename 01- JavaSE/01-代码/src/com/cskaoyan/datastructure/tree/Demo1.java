package com.cskaoyan.datastructure.tree;

/*
        Comparable接口

 */
public class Demo1 {
    public static void main(String[] args) {


        User first = new User("zs", 18);
        User second = new User("lisi", 20);
        // 只要实现了Comparable接口，任意类型的对象就都可以比较
        int result = first.compareTo(second);
        System.out.println(result);
    }
}

class User implements Comparable<User> {

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        // 自定义比较规则
        int nameResult = name.compareTo(o.name);
        if (nameResult != 0) {
            return nameResult;
        }

        // 名字相同
        if (age > o.age) {
            return 1;
        }

        if (age < o.age) {
            return -1;
        }
        return 0;
    }
}
