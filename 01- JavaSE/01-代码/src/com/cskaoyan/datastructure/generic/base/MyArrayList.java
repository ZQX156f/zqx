package com.cskaoyan.datastructure.generic.base;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/*
     基于数组实现的线性表
     1. 按内容的增删改查
     2. 按位序的增删改查
      注意:
        数组扩容
        元素移动
 */
public class MyArrayList<T> {

    private static final int INIT_CAPACITY = 10;

    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    // 存储线性表中数据的数组
    private Object[] elementData;

    // 表示线性表中的元素个数
    private int size;

    public MyArrayList() {
        elementData = new Object[INIT_CAPACITY];
    }

    public MyArrayList(int size) {
        if (size < 0 || size > MAX_CAPACITY) {
                throw new IllegalArgumentException("size: " + size);
        }
        elementData = new Object[size];
    }



    /*
            在最后一个元素之后，添加value
         */
    public boolean add(T value) {
        // 考虑数组的容量，size == elementData.length
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
        return true;
    }

    /*
         删除数组中执行的value值的元素
     */
    public boolean remove(T value) {
        if (size == 0) {
            throw new NoSuchElementException(value.toString());
        }

        // 待删除的元素位置
        int index = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (Objects.equals(value, elementData[i])) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // 没有找到待删除的元素
            return false;
        }

        // 找到了待删除的元素
        //  index + 1      size - 1    (size - 1) -(index + 1) + 1 = size - index - 1
        int numToMove = size - index - 1;
        if (numToMove > 0) {
            System.arraycopy(elementData,index + 1, elementData, index, numToMove);
        }
        size--;
        return true;
    }


    public boolean set(T oldValue, T newValue) {
        if (size == 0) {
            throw new NoSuchElementException(oldValue.toString());
        }

        for (int i = 0; i < elementData.length; i++) {
            if (Objects.equals(oldValue, elementData[i])) {
                elementData[i] = newValue;
                return true;
            }
        }

        return false;
    }

    public boolean contains(T value) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < elementData.length; i++) {
            if (Objects.equals(value, elementData[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean add(int index, T value) {
        // 判断下标的合法性
        rangeCheckForAdd(index);

        //在指定位置添加元素
        // index    size - 1   size - 1 - index + 1 = size -index
        int numToMove = size - index;
        if (numToMove > 0) {
            System.arraycopy(elementData, index, elementData, index + 1, numToMove);
        }

        elementData[index] = value;
        size++;
        return true;
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public T remove(int index) {
        // 检查下标的合法性
        rangeCheck(index);

        Object oldValue = elementData[index];

        int numToMove = size - 1 - index;
        if (numToMove > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numToMove);
        } else {
            elementData[index] = null;
        }

        size--;
        return (T) oldValue;
    }

    public T set(int index, Object value) {
        // 检查下标的合法性
        rangeCheck(index);

        Object oldValue = elementData[index];
        elementData[index] = value;
        return (T) oldValue;
    }

    public T get(int index) {
        // 检查下标的合法性
        rangeCheck(index);
        return (T) elementData[index];
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }


    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

    }


    private void ensureCapacity(int minCapacity) {

        if (elementData.length >= minCapacity) {
            // 如果数组满足了最小的存储空间的需要
            return;
        }

        // 插入元素需要的最小的存储空间，超过了数组的长度
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;
        if (newCapacity > MAX_CAPACITY || newCapacity < 0) {
            newCapacity = MAX_CAPACITY;
        }

        if (oldCapacity == newCapacity) {
            throw new RuntimeException("store full!");
        }

        // 完成扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


}
