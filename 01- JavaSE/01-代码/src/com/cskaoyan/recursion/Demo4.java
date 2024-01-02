package com.cskaoyan.recursion;

/*
    斐波那契(Fibonacci)数列
        1, 1 , 2 , 3 , 5 , 8 , 13 , 21.....

    递归求解斐波那契数列第n项的值

    f(n) = f(n - 1) + f(n - 2)
    f(1) = 1
    f(2) = 1
 */
public class Demo4 {

    public static void main(String[] args) {
        int fibonacci = fibonacci(8);
        System.out.println(fibonacci);
    }

    public static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        // 分解
        return fibonacci( n - 1) + fibonacci(n - 2);

    }



}

class MyClass{}
