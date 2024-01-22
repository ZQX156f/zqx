package com.cskaoyan.datastructure.list.link;

import java.util.Objects;

/*
      基于双向链表实现的线性表
      1. 基本的按内容增删改查
      2. 根据位序实现
 */
public class Demo2 {

    public static void main(String[] args) {

        MyDBLikedList myDBLikedList = new MyDBLikedList();

        // 按内容增删改查
        //testContent(myDBLikedList);

        // 测试位序操作
        myDBLikedList.add(0, "0");
        myDBLikedList.add(1, "1");
        myDBLikedList.add(2, "2");
        myDBLikedList.add(1, "aaa");


        // 修改指定位置的元素值
        myDBLikedList.set(1, "abc");
        myDBLikedList.set(3, "ddd");
        myDBLikedList.set(0, "yyy");


        myDBLikedList.remove(3);
        myDBLikedList.remove(1);
        myDBLikedList.remove(0);


    }

    private static void testContent(MyDBLikedList myDBLikedList) {
        myDBLikedList.add("1");
        myDBLikedList.add("2");
        myDBLikedList.add("3");

        myDBLikedList.set("3", "333");
        myDBLikedList.set("1", "111");

        myDBLikedList.remove("3");
        myDBLikedList.remove("1");
        myDBLikedList.remove("2");
    }
}

class MyDBLikedList {

    // 指向双向链表的第一个节点
    private Node head;

    // 指向双向链表的最后一个节点
    private Node tail;

    private int size;

    /*
        向双向链表末尾插入新的节点，节点的value值是指定值
     */
    public boolean add(String value) {
        if (head == null) {
            // 待插入的元素是双向链表中的第一个节点
            head = new Node(value);
            tail = head;
            size++;
            return true;
        }

        // 找到链表的尾节点
        Node node = new Node(value);
        node.pre = tail;
        tail.next = node;
        tail = node;
        size++;
        return true;
    }

    /*
        在链表中删除指定value值的节点
     */
    public boolean remove(String value) {

        if (head == null) {
            // 链表是空的
            return false;
        }

        // 非空链表
        if (Objects.equals(head.value, value)) {
            // 第一个节点
            if (size == 1) {
                // 只剩一个节点的时候
                head = null;
                tail = null;
                size--;
                return true;
            }

            // 将第二个阶段前驱变为null
            head.next.pre = null;
            head = head.next;
            size--;
            return true;
        }

        // 删除中间或者尾节点
        // mid指向的是待删除节点的前一个节点
        Node mid = head;
        while (mid.next != null && !Objects.equals(mid.next.value, value)) {
            mid = mid.next;
        }

        // 没有找到待删除的元素
        if (mid.next == null) {
            return false;
        }

        if (mid.next == tail) {
            // 删除尾节点
            mid.next = null;
            tail = mid;
            size--;
            return true;
        }

        // 删除中间节点
        Node curNode = mid.next;
        curNode.next.pre = mid;
        mid.next = curNode.next;
        size--;
        return true;
    }

    /**
     * 判断链表中是否包含值为value的节点
     *
     * @param value
     * @return
     */
    public boolean contains(String value) {
        if (head == null) {
            return false;
        }

        Node mid = head;
        while (mid != null && !Objects.equals(mid.value, value)) {
            mid = mid.next;
        }

        if (mid == null) {
            // 不包含
            return false;
        }

        return true;
    }


    /*
        将链表中值为oldValue的节点值，修改为newValue
     */
    public boolean set(String oldValue, String newValue) {
        if (head == null) {
            return false;
        }

        Node mid = head;
        while (mid != null && !Objects.equals(mid.value, oldValue)) {
            mid = mid.next;
        }

        if (mid == null) {
            // 没有置为oldValud的节点
            return false;
        }

        mid.value = newValue;
        return true;

    }

    /*
         在指定位置插入元素
     */
    public boolean add(int index, String value) {
        // 检查位序的合法性
        rangeCheckForAdd(index);

        if (index == 0) {
            // 插入头结点
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node node = new Node(value);
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
            return true;
        }

        if (index == size) {
            // 调用已经实现的方法
            return add(value);
        }

        // 在链表的中间插入元素
        Node mid;
        if (index >= size / 2) {
            // 从前向后找
            mid = head;
            // 0    1         index
            // head       mid
            for (int i = 1; i < index; i++) {
                mid = mid.next;
            }
        } else {
            // 从后向前找
            mid = tail;
            // i size - 1   index - 1  index
            //  size - 1    mid
            for (int i = size - 1; i >= index; i--) {
                mid = mid.pre;
            }
        }

        // mid 指向了第index-1 位置
        Node node = new Node(value);
        node.next = mid.next;
        node.pre = mid;
        mid.next.pre = node;
        mid.next = node;
        size++;
        return true;
    }

    /*
        删除第index个位置的节点
     */
    public String remove(int index) {
        // 检查位序
        rangeCheck(index);

        // 是否删除头结点
        if (index == 0) {
            if (size == 1) {
                // 只剩一个元素
                String value = head.value;
                head = null;
                tail = null;
                size--;
                return value;
            }

            // 不止一个节点
            // 将第二个节点的前驱改为null
            String value = head.value;
            head.next.pre = null;
            head = head.next;
            size--;
            return value;
        }

        if (index == size - 1) {
            // 删除尾节点
            String value = tail.value;
            Node preNode = tail.pre;
            preNode.next = null;
            tail = preNode;
            size--;
            return value;
        }

        // 删除中间节点
        Node mid;
        if (index >= size / 2) {
            // 从前向后
            mid = head;
            for (int i = 1; i < index; i++) {
                mid = mid.next;
            }
        } else {
            // 从后往前
            mid = tail;
            for (int i = size - 1; i >= index ; i--) {
                mid = mid.pre;
            }
        }

        // mid 指向了index-1位置的元素
        Node curNode = mid.next;
        curNode.next.pre = mid;
        mid.next = curNode.next;
        size--;
        return curNode.value;
    }

    public String set(int index, String value) {
        // 判断位序的合法性
        rangeCheck(index);

        Node mid;
        if (index <= size / 2) {
            mid = head;
            // 从前往后
            for (int i = 0; i < index; i++) {
                mid = mid.next;
            }
        } else {
            // 从后往前
            mid = tail;
            for (int i = size - 1; i > index ; i--) {
                mid = mid.pre;
            }
        }

        // mid 指向的是第index位置的元素
        String oldValue = mid.value;
        mid.value = value;
        return oldValue;
    }

    public String get(int index) {
        return null;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }


    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }



    class Node {

        String value;

        Node pre;

        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
