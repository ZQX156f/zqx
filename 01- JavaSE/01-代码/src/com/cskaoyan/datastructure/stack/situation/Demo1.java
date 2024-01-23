package com.cskaoyan.datastructure.stack.situation;

import com.cskaoyan.datastructure.stack.array.MyArrayStack;
import com.cskaoyan.datastructure.stack.linked.MyLinkedStack;

/*
    栈的应用

应用场景：
1, 函数调用栈
2, 反序字符串
3, 括号匹配问题
4, 编译器利用栈实现`表达式求值`
5, 浏览器的前进后退功能
6, 利用栈实现 DFS: depth-first-search  深度优先遍历

 */
public class Demo1 {

    public static void main(String[] args) {
//        字符串逆序
//        String s = "12345678";
//        String result = reverseString(s);
//        System.out.println(result);

//        括号匹配
        String brackets = "class { public static void main(String[ args";
        boolean b = judgeBrackets(brackets);
        System.out.println(b);
    }
    /*
        )abdcefg
        1. 当我们遇到一个{或[或(, 分别入栈对应的有括号}, ], )
        2. 当遍历字符时我们遇到}或者)或者]，将栈顶元素出栈
        依次重复1,2两个过程，直到遍历完了字符

     */
    public static boolean judgeBrackets(String s) {

        MyLinkedStack<Character> stack = new MyLinkedStack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '}' || c == ']' || c == ')') {

                if (stack.isEmpty()) {
                    return false;
                }
                char b = stack.pop();
                if (b != c) {
                    return false;
                }
            }
        }

        // 栈空才意味着所有的括号匹配上了
        return stack.isEmpty();
    }




    public static String reverseString(String orignalStr) {

        // 创建动态字符串
        StringBuffer stringBuffer = new StringBuffer();

        MyLinkedStack<Character> stack = new MyLinkedStack<>();

        for (int i = 0; i < orignalStr.length(); i++) {
            char c = orignalStr.charAt(i);
            // 入栈
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            Character c = stack.pop();
            stringBuffer.append(c);
        }

        return stringBuffer.toString();
    }
}
