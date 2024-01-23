package com.cskaoyan.datastructure.tree;

/*

        1. 二叉搜索树中存储的是任意一种 可以比较的元素
           可以通过 T extends Comparable，限定泛型类型必须是Comparable子类类型
 */
public class MyBSTree<T extends Comparable> {

    // 二叉搜索树的根节点
    private Node root;

    // 元素个数
    private int size;


    public boolean add (T t) {

        if (root == null) {
            root = new Node(t);
            size++;
            return true;
        }

        Node mid = root;
        Node midF = null;

        while (mid != null) {

            int result = t.compareTo(mid.value);
            if (result > 0) {
                midF = mid;
                mid = mid.right;
            } else if (result < 0){
                midF = mid;
                mid = mid.left;
            } else {
                // 不可以 存在重复元素
                //   计数法
                //   拉链法
                return false;
            }
        }

        // mid == null
        if (t.compareTo(midF.value) > 0) {
            // 右子树
            midF.right = new Node(t);
        } else {
            midF.left = new Node(t);
        }

        size++;
        return  true;
    }





   class Node {
       T value;

       // 左孩子
       Node left;
       // 右孩子
       Node right;

       public Node(T value) {
           this.value = value;
       }
   }
}

