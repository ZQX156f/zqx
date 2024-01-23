package com.cskaoyan.datastructure.stack.array;

public class MyArrayStack<T> {

    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    private static final int INIT_CAPACITY = 10;


    private Object[] elementData;

    private int size;

    public MyArrayStack() {
    }

    public MyArrayStack(int size) {
        this.size = size;
    }

    public boolean add(T e) {
        // 注意扩容
        return true;
    }
}
