package com.cskaoyan.datastructure.tree;


/*
        测试二叉搜索树

        //30 100 50 40 25 55 120 200 10 28 0 5 -1 27

 */
public class Demo2 {

    public static void main(String[] args) {

        MyBSTree<Integer> comparableMyBSTree = new MyBSTree<>();

        comparableMyBSTree.add(30);
        comparableMyBSTree.add(100);
        comparableMyBSTree.add(50);
        comparableMyBSTree.add(40);
        comparableMyBSTree.add(25);
        comparableMyBSTree.add(55);
        comparableMyBSTree.add(120);
        comparableMyBSTree.add(200);
        comparableMyBSTree.add(10);
        comparableMyBSTree.add(28);
        comparableMyBSTree.add(0);
        comparableMyBSTree.add(5);
        comparableMyBSTree.add(-1);
        comparableMyBSTree.add(27);


        //comparableMyBSTree.remove(30);


        //comparableMyBSTree.printPreOrder();
        //comparableMyBSTree.printInOrder();
        //comparableMyBSTree.printPostOrder();

        comparableMyBSTree.printBFS();


    }
}
