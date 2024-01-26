package com.cskaoyan.set;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/*
        HashSet extends Set
        Set extends Collection
 */
public class Demo1 {


    public static void main(String[] args) {

        // HashMap特征: key
//        HashSet<String> strings = new HashSet<>();
//
//        boolean result = strings.add("aaa");
//        System.out.println(result);
//        result = strings.add("aaa");
//        System.out.println(result);

        User first = new User(18, "zs");
        User second = new User(18, "zs");

        HashSet<User> users = new HashSet<>();


        /*
                if (p.hash == hash &&
                      ((k = p.key) == key || (key != null && key.equals(k))))
         */
        boolean add = users.add(first);
        System.out.println(add);
        add = users.add(second);
        System.out.println(add);


    }

}

class User {

    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
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
        return Objects.hash(age, name);
    }
}
