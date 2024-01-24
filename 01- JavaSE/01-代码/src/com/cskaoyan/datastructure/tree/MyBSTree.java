package com.cskaoyan.datastructure.tree;

import com.cskaoyan.datastructure.list.link.MyDBLinkedList;
import com.cskaoyan.datastructure.stack.linked.MyLinkedStack;

import java.util.NoSuchElementException;

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

        // 不允许插入null值
        if (t == null) {
            throw new IllegalArgumentException("value: " + t);
            //return false;
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


    public boolean addNonRecursive(T t) {

        root = insert(t, root);
        return true;
    }

    private Node insert(T t, Node root) {
        if (root == null) {
            return new Node(t);
        }

        int result = t.compareTo(root.value);
        if (result > 0) {
            root.right = insert(t, root.right);
        } else if(result < 0) {
            root.left = insert(t, root.left);
        } else {
            // 不会存在这种情况
        }

        return root;
    }

    public boolean removeRecursive(T t) {
        root = delete(t, root);
        return true;
    }

    private Node delete(T t, Node root) {
        if (root == null) {
            return null;
        }
        int result = t.compareTo(root.value);
        if (result > 0) {
            root.right = delete(t, root.right);
        } else if(result < 0) {
            root.left = delete(t, root.left);
        } else {
          // 找到了待删除节点
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 如果既有做孩子，又有有孩子
            Node rightMin = recursiveMin(root.right);

            // 修改待删除节点的值
            root.value = rightMin.value;

            root.right =  delete(t, root.right);

            return root;
        }

        return root;
    }


    public Node recursiveMin(Node root) {

        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        return recursiveMin(root.left);

    }





    public boolean remove(T t) {

        if (root == null) {
            throw new NoSuchElementException();
        }

        if (t == null) {
            // 没有null值
            return false;
        }


        Node mid  = root;
        Node midF = null;
        while (mid != null) {

            int result = t.compareTo(mid.value);
            if (result > 0) {
                midF = mid;
                mid = mid.right;
            } else if (result < 0) {
                midF = mid;
                mid = mid.left;
            } else {
                // 找到了待删除的节点
                break;
            }
        }

        // 两种情况: 1. 没有找到待删除的元素  2. 找到了待删除的元素
        if (mid == null) {
            // 没有找到待删除元素
            return false;
        }

        // 找到了待删除元素
        if (mid.left != null && mid.right != null) {
            // 两个孩子存在
            // 转化，找到mid右子树的最小值
            Node rightMin = mid.right;
            Node rightMinF = mid;

            while (rightMin.left != null) {
                rightMinF = rightMin;
                rightMin = rightMin.left;
            }

            // rightMin 指向了 mid的右子树中，最左边的节点(最小的节点)
            // 将右子树 最小节点值，赋值给待删除节点的value
            mid.value = rightMin.value;
            mid = rightMin;
            midF = rightMinF;

        }

        // 考虑一种情况，待删除的节点，只有一个孩子（两个孩子）
        Node child = mid.left != null ? mid.left : mid.right;

        // 为了防止没有父节点的情况
        if (midF == null) {
           // 说明要删除的是 根节点，根节点最多只有一个孩子
            root = child;
            size--;
            return true;
        }

        // 用孩子节点  替换待删除的节点
        if (midF.left == mid) {
            midF.left = child;
        } else {
            midF.right = child;
        }

        size--;
        return true;
    }

    /*
          你们的作业
     */
    public boolean contains(T t) {

        return true;
    }


    public void printPreOrder() {
        MyDBLinkedList<T> list = new MyDBLinkedList<>();

        preOrder(root, list);

        System.out.println(list);

    }

    public void printInOrder() {
        MyDBLinkedList<T> list = new MyDBLinkedList<>();

        inOrder(root, list);

        System.out.println(list);
    }



    /*
         递归先序遍历
     */

    public void preOrder(Node root, MyDBLinkedList<T> list) {
        if (root == null) {
            return;
        }

        // 先访问根
        list.add(root.value);
        // 访问左子树
        preOrder(root.left, list);
        // 访问右子树
        preOrder(root.right, list);

    }

    public void preOrderNonRecursive(Node root, MyDBLinkedList<T> list) {

        MyLinkedStack<Node> stack = new MyLinkedStack<>();
        // 根节点入栈
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            // 先访问根节点
            list.add(node.value);

            // 入栈右孩子
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

    }

    public void inOrder(Node root, MyDBLinkedList<T> list) {
        if (root == null) {
            return;
        }

        // 访问左子树
        preOrder(root.left, list);

        // 先访问根
        list.add(root.value);
        // 访问右子树
        preOrder(root.right, list);

    }

    public void postOrder(Node root, MyDBLinkedList<T> list) {

        if (root == null) {
            return;
        }

        postOrder(root.left, list);

        postOrder(root.right, list);

        // 访问根节点
        list.add(root.value);
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

