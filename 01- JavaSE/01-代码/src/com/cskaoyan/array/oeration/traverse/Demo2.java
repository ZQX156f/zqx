package com.cskaoyan.array.oeration.traverse;

import java.util.Arrays;

/*

    增强形式的for循环，它是for循环的一种变体, 用它遍历数组方便，一旦使用它就会遍历数组中的所有元素
        for(数据类型 变量名 : 要遍历的数组或者集合){
	       System.out.println(变量名);
	     }

	 增强for和普通for遍历数组时的区别：
    1. 增强for的语法更简洁，并且遍历效率也会更高一点。
    2. 增强for循环中没有使用数组下标，而是直接遍历元素。当你想要在循环中使用数组下标时，就无法使用增强for了。
    3. 增强for仅仅作为一个遍历数组/集合的工具而存在， 在增强for当中是不能修改任何元素的取值的。
}

 */
public class Demo2 {

    public static void main(String[] args) {

        int[] array = {1, 25, 5, 6};

        // 增强形式的for循环
        for (int i : array) {
            // 无法在循环过程中，获取数组下标，无法修改数组中的当前元素值
            i = 100;
            //System.out.println(i);
        }

        System.out.println(Arrays.toString(array));
    }
}
