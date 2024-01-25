package com.cskaoyan.collection.list.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
     Stack extends Vector: 加锁，访问效率不高
 */
public class Demo1 {
    public static void main(String[] args) {
       // Stack<String> stack = new Stack<>();
        // 入栈
        //stack.push("a");
        // 出栈
        //stack.pop();


        Deque<String> stack = new ArrayDeque<>();
        //入栈
        stack.push("a");

        // 出栈
        stack.pop();

    }
}
