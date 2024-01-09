package com.cskaoyan.object;

import java.util.Objects;

/*
     public native int hashCode();
     返回该对象的哈希码值   hash映射  对象 ——> 整数值


     Object默认实现，将每个对象的内存地址 ——> 整数值， java语言不需要

     自己实现:
     1. 在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，
        前提是将对象进行 equals比较时所用的信息没有被修改。
        a. 结果是稳定的
        b. 只要对象的成员变量值没有被修改，hashCode不变

     2. 如果根据 equals(Object)方法，两个对象是相等的，那么对这两个对象中的每个对象调用hashCode方法都必须生成相同的整数结果。

     3. 如果根据 equals(java.lang.Object)方法，两个对象不相等，
        那么对这两个对象中的任一对象上调用hashCode方法不要求一定生成不同的整数结果。

        但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。

        我们不需要知道，具体怎么去计算对象的hash值，只需要知道，不管怎么计算，都必须使用对象的成员变量值来计算

 */
public class Demo5 {
    public static void main(String[] args) {

        HashClass first = new HashClass(90,100);
        int i = first.hashCode();

        HashClass second = new HashClass(90, 100);
        int j = second.hashCode();
        System.out.println(i == j);
    }
}

class HashClass {

    int i;
    double j;

    public HashClass(int i, double j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashClass hashClass = (HashClass) o;
        return i == hashClass.i && Double.compare(j, hashClass.j) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}

