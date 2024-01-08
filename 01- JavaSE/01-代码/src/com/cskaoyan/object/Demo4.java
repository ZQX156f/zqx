package com.cskaoyan.object;

import java.math.BigDecimal;
import java.util.Objects;

/*
        public boolean equals(Object obj)
         指示其他某个对象是否与此对象“相等”。
         对象.equals(obj)

         何时对象相等? 从对象的差异性的角度理解，对象的差异主要体现在对象的类型和对象的
         成员变量取值

         Object 类的 equals 方法实现对象上差别可能性最大的相等关系；
         即，对于任何非空引用值 x 和 y，当且仅当 x 和 y 引用同一个对象时，
         此方法才返回 true（x == y 具有值 true）。

     对于以上比较规则的equals方法的重写，Java官方为我们提供了官方的要求，称之为equals方法重写的常规协定：
    1. 自反性：对于任何非空引用值 x，x.equals(x)都应返回 true
    2. 对称性：对于任何非空引用值 x 和 y，当且仅当y.equals(x) 返回 true 时，x.equals(y) 才应返回true
    3. 传递性：对于任何非空引用值 x、y 和 z，如果x.equals(y)返回 true，并且 y.equals(z) 返回 true，那么x.equals(z) 应返回 true。
    4. 一致性：对于任何非空引用值 x 和 y，多次调用 x.equals(y)始终返回 true 或始终返回 false。 前提是对象上 equals 比较中所用的信息没有被修改。
        a. 结果是稳定的
        b. 用于做对象比较的信息: 就是对象成员变量值
    5. 排他性：当比对的不是同种类型的对象或者是一个null时，默认返回false


    构造方法:
        BigDecimal(String val)
        将 BigDecimal 的字符串表示形式转换为 BigDecimal。

        成员方法:
        减法
        BigDecimal subtract(BigDecimal subtrahend)

        加法:
        BigDecimal add(BigDecimal augend)
 */
public class Demo4 {

    public static void main(String[] args) {

        EqualClass first = new EqualClass(10, 20);
        EqualClass second = new EqualClass(10, 20);

        EqualClass third = new EqualClass(100, 200);

        // 使用Object中定义的equals方法比较

        // 应该不等的情况  false
        boolean equals = first.equals(third);
        //System.out.println(equals);

        // 应该相等的情况  false
        equals = first.equals(second);
        //System.out.println(equals);

        // BigDecimal

        // 创建BigDecimal对象
        BigDecimal firstBigDeciamal = new BigDecimal("1.5");

        BigDecimal secondBigDeciamal = new BigDecimal("1");

        // 减法运算
        BigDecimal subtract = firstBigDeciamal.subtract(secondBigDeciamal);
        System.out.println(subtract);

        //
        BigDecimal add = firstBigDeciamal.add(secondBigDeciamal);
        System.out.println(add);


    }
}

class EqualClass {

    int i;
    double j;

    public EqualClass(int i, double j) {
        this.i = i;
        this.j = j;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) {
//          // 满足自反性
//            return true;
//        }
//
//        // 不同类型的对象，或者 obj等于null 结果不相等
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//
//        // 同种类型的对象作比较
//        EqualClass that = (EqualClass) obj;
//        if (i != that.i) {
//            return false;
//        }
//        //  compare方法返回值int， 返回值等于0的时候
//        return Double.compare(j, that.j) == 0;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualClass that = (EqualClass) o;
        return i == that.i && Double.compare(j, that.j) == 0;
    }
}
