package com.cskaoyan.datastructure.base;

/*
        举例 JDK中的实现

 */
public class Demo2 {

    public static void main(String[] args) {
        // MyCollection 存储数据的容器
        MyCollection myCollection = new MyCollection();

        // 存入数据
        myCollection.add("1");
        myCollection.add("2");
        myCollection.add("3");
        myCollection.add("4");

        // 判断数据
        boolean contains = myCollection.contains("1");
        System.out.println(contains);
    }
}

class MyCollection {

    // 它用来存储数据
    private Object[] array;

    // 表示当前放入数组的元素的个数
    int size;

    public MyCollection() {

       array = new String[10];
    }

    public void add(Object data) {

        // 放入数据之前，检索数组，如果数组满了
        array[size] = data;
        size++;
    }

    public boolean contains(String param) {

        for (int i = 0; i < size; i++) {
            if (array[i].equals(param)) {
                return true;
            }
        }

        return false;
    }




}
