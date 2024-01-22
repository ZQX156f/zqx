package com.cskaoyan.datastructure.list.link;


import java.util.NoSuchElementException;
import java.util.Objects;

/*
     基于链表实现线性表
     1. 按内容
       a. 增
       b. 删
       c. 改
       d. 查
     2. 位序
       a. 增
       b. 删
       c. 改
       d. 查

 */
public class Demo1 {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        // 测试基于内容的增删改查
        //testWithValue(linkedList);

        // 测试基于位序的增删改查

        linkedList.add(0, "0");
        linkedList.add(1, "1");
        linkedList.add(2, "2");
        linkedList.add(3, "3");

        String remove = linkedList.remove(3);
        System.out.println(remove);

        String remove1 = linkedList.remove(1);
        System.out.println(remove1);


    }

    private static void testWithValue(LinkedList linkedList) {
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");

        // 存储一个null值
        //linkedList.add(null);

        //linkedList.set("1", "111");

        boolean contains = linkedList.contains("40");
        System.out.println(contains);


        linkedList.remove("3");
        linkedList.remove("1");
        linkedList.remove("2");
        linkedList.remove("4");
    }
}

class LinkedList {

    // 指向链表中的第一个节点
    private Node head;

    // 表示链表中的元素个数
    private int size;

    /**
     * 没有指定元素的位置，默认添加到最后一个位置
     * @param value 待插入的元素值
     * @return
     */
    public boolean add(String value) {

        // 创建待插入的节点
        Node newNode = new Node(value);

        if (head == null) {
          // 当前插入的元素是链表的第一个元素
          head = newNode;
          size++;
          return true;
        }

        // 找到待插入元素的前一个节点即可
        Node mid = head;

        while (mid.next != null) {
            mid = mid.next;
        }

        // mid 指向了最后一个节点
        mid.next = newNode;
        size++;
        return true;
    }

    /**
     * 删除链表中，和参数值取值相同的那个节点
     * @param value 待删除的元素值
     * @return
     */
    public boolean remove(String value) {
        if (head == null) {
            // 链表是空的
            //throw new NoSuchElementException();
            return false;
        }


        // 引入一个比较是否相等的工具方法
        // 替换 head.value.equals(value)
        if (Objects.equals(head.value, value)) {
          // 头结点 value 等于 参数value
            head = head.next;
            size--;
            return true;
        }

        // 循环比较，非头结点的其他节点
        Node mid = head;
        // mid 永远表示待删除节点的前一个节点
        while (mid.next != null && !Objects.equals(mid.next.value, value)) {
            mid = mid.next;
        }

        /*
             两种情况:
             1. 没有找到待删除的元素
             2. 找到了待删除的元素对应的节点，删除对应的节点
         */
        if (mid.next == null) {
            return false;
        }

        // 已经找到了待删除的元素对应的节点(mid指向其前一个节点)
        Node cur = mid.next;
        mid.next = cur.next;
        size--;
        return true;
    }

    /**
     *  将链表中value值为oldValue的value值，改为newValue
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean set(String oldValue, String newValue) {
        // 判断链表是否为null
        if (head == null) {
            throw new NoSuchElementException(oldValue);
        }

        Node mid = head;
        while (mid != null && !Objects.equals(oldValue, mid.value)) {
            mid = mid.next;
        }

        if (mid == null) {
           // 找到链表末尾
           return false;
        }

        // 找到了 value值等于 oldValue的节点
        mid.value = newValue;
        return true;

    }

    /*
        判断链表中是否有一个节点的值等于value
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
            // 没找到
            return false;
        }
        return true;
    }


    /*
        将指定元素添加到链表的指定下标位置
     */
    public boolean add(int index, String value) {

        // 判断index 是否合法  2 合法的插入位置 0，1,2
        rangeCheckForAdd(index);

        // 位序是合法的
        if (index == 0) {
          // 在第一个位置插入
          if (head == null) {
            head = new Node(value);
          } else {
              Node node = new Node(value);
              node.next = head;
              head = node;
          }
          size++;
          return true;
        }
        // 插入位置在中间，或在末尾
        Node mid = head;
        // i   0         index
        // mid head  mid
        for (int i = 1; i < index; i++) {
            mid = mid.next;
        }

        // mid 指向了待插入的index 位置的前一个节点
        Node node = new Node(value);
        node.next = mid.next;
        mid.next = node;
        size++;
        return true;

    }

    public String remove(int index) {
        // 判断index是否合法
        rangeCheck(index);

        // 说明位序合法
        if (index == 0) {
            // 存储删除的元素值
            String value = head.value;
            head = head.next;
            size--;
            return value;
        }

        Node mid = head;
        // 删除中间，或者末尾的节点
        // 0    1    index
        // head   mid
        for (int i = 1; i < index; i++) {
            mid = mid.next;
        }

        // 删除 mid指向的是待删除节点的前一个节点
        Node cur = mid.next;
        mid.next = cur.next;
        size--;
        return cur.value;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            // 不合法
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            // 插入的位序不合法
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    /*
         修改指定下标的节点的值为value
     */
    public boolean set(int index, String value) {

        return false;
    }

    /*
        获取指定下标位置的节点值
     */
    public String get(int index) {

        return null;
    }

   // 内部类
    class Node {

       String value;

       Node next;

       public Node(String value) {
           this.value = value;
       }
   }

}
