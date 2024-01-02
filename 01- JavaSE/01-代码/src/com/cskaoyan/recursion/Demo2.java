package com.cskaoyan.recursion;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/*
       有三根杆子A，B，C。A杆上有 N 个 (N>1) 穿孔圆盘，盘的尺寸由下到上依次变小。要求按下列规则将所有圆盘移至 C 杆：
            a.每次只能移动一个圆盘
            b.大盘不能叠在小盘上面
        提示：可将圆盘临时置于 B 杆，也可将从 A 杆移出的圆盘重新移回 A 杆，但都必须遵循上述两条规则。
        问：最少要移动多少次？如何移？

    解决思路以N个圆盘为例：
    1. 当我们要解决N个圆盘的搬运问题，对于N个圆盘，我们可能无法一次性得到结果，
       于是，我们把N个圆盘的搬运问题， -> 最大一个的圆盘的搬运 & 最大圆盘上面的 n - 1

    2. 对于规模为1那个待搬运的最大的圆盘，直接就知道如何搬运（一步搞定）

    3. 在2的基础上，只需要，再解决 N - 1个圆盘搬运的问题

    A——>C
    A——>B
    C——>B
    A——>C
    B——>A
    B——>C
    A——>C

     递归算法的核心思想:
        将一个大规模的复杂问题，分解成若干相似的小规模的子问题，解决小规模的子问题，将其组合起来，就得到了大规模问题的解


 */
public class Demo2 {

    public static void main(String[] args) {
        hanoi(3, 'A', 'C', 'B');
    }


    /*
        n： 表示当前待搬运的圆盘数量
        start：起始杆的名字(待搬运圆盘所在的杆)
        end: 待搬运的圆盘，所搬运到的目标杆的名字
        middle: 从start到end搬运过程中所使用的的辅助杆
        基于递归方法实现
     */
    public static void hanoi(int n, char start, char end, char middle) {

        if (n == 1) {
            System.out.println(start + "——>" + end);
            return;
        }

        // 先将最大的盘上面的那n-1个盘，从start ——> middle
        hanoi(n - 1, start, middle, end);

        // 问题已经得到了分解，将一个子问题解决，完成最大的圆盘的搬运
        System.out.println(start + "——>" + end);


        // 将辅助杆上的n-1个圆盘 ——> 目标杆
        hanoi(n - 1, middle, end, start);
    }
}
