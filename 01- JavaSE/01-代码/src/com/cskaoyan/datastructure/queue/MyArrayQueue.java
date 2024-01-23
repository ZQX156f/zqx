package com.cskaoyan.datastructure.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayQueue<T> {

    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;


    private static final int INIT_CAPACITY = 10;

    Object[] elementData;

    private int size;

    // 指向队头的下标
    int head;
    // 指向队尾的下标
    int rear;

    public MyArrayQueue() {
        elementData = new Object[INIT_CAPACITY];
    }

    public MyArrayQueue(int size) {
        if (size < 0 || size > MAX_CAPACITY) {
            throw new IllegalArgumentException(size + "");
        }
        elementData = new Object[size];
    }

    /*
        向队尾添加元素
     */
    public boolean offer(T e) {

        ensureCapacity(size + 1);
        // 在队尾放入元素
        elementData[rear] = e;

        // 队尾向后移动一位
        rear = (rear + 1) % elementData.length;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (elementData.length >= minCapacity) {
            return;
        }

        // 需要扩容
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;

        if (newCapacity > MAX_CAPACITY || newCapacity < 0) {
            newCapacity = MAX_CAPACITY;
        }

        if (oldCapacity == newCapacity) {
          // 已经达到最大容量
          throw new RuntimeException("store full!");
        }

        // 扩容
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = elementData[head + i];
        }
        elementData = newArray;
        head = 0;
        rear = size;

    }

    /*
         出队列(删除对头元素)
     */
    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        if (size == 1) {
            T oldValue = (T) elementData[head];
            head = 0;
            rear = 0;
            size--;
            return oldValue;
        }

        // 元素不止一个
        T oldValue = (T) elementData[head];
        elementData[head] = null;
        head = (head + 1) % elementData.length;
        size--;
        return oldValue;
    }

    /*
        获取队头元素的值
     */
    public T peak() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return (T) elementData[head];
    }


}
