package com.cskaoyan.oop.block;

/*

        代码块的定义：由若干条Java语句组成，并且用一对大括号括起来的结构，叫做代码块。

        代码块的分类，根据其位置和声明方式的不同，可以分为：
        - 局部代码块
        - 构造代码块
        - 静态代码块
        - 同步代码块

        构造代码块:
          定义在类的成员位置，使用以下声明方式声明的代码块，称之为构造代码块。
        执行时机: 创建对象的过程中执行
        作用: 可以用于在创建对象的过程中给成员变量赋初值

        执行顺序:  成员变量的显示赋值语句和构造代码块的执行顺序 和书写书序 有关

 */
public class Demo1 {

    public static void main(String[] args) {
        ConstructBlock constructBlock = new ConstructBlock();

        // 访问i成员变量的值
        //System.out.println(constructBlock.i);

        ConstructBlock constructBlock1 = new ConstructBlock(10, 20);
    }
}

class ConstructBlock {
//    显示赋值语句，可以放在构造代码块之前
//    int i = -1;

    double j;

    // 构造代码块
    {
        // 构造代码块中定义的变量，仍然是局部变量
        i = 100;
        System.out.println("construct block run");
    }

    int i = -1;

    static  double staticField;
    {
        // 访问静态变量
        staticField = 100;
    }

    public ConstructBlock() {
    }

    public ConstructBlock(int i) {
        this.i = i;
    }


    public ConstructBlock(int i, double j) {
        this(i);
        this.j = j;
    }

}
