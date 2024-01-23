package com.cskaoyan.datastructure.stack.linked;

public class Test {

    public static void main(String[] args) {
        MyLinkedStack<String> stack = new MyLinkedStack<>();

        // 入栈
        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peak());
    }
}
