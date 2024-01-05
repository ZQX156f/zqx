package com.cskaoyan.oop2.extend.init.explicit;


/*
      什么是super关键字？

    上面其实已经说过了，你完全可以直接把super关键字，看成指向当前类的父类"对象"的一个引用。即：
    1. this代表当前类的当前对象。
    2. super表示当前类的父类对象。

    子类对象的显示初始化: 在子类构造方法的第一条语句的位置 super(实参列表) 显示调用父类的
    构造方法

 */
public class Demo1 {

    public static void main(String[] args) {
        ExplicitSon explicitSon = new ExplicitSon(10, 20);

        System.out.println(explicitSon.father);

        System.out.println(explicitSon.son);
    }
}

class ExplicitFather {

    int father;

    public ExplicitFather() {
    }

    public ExplicitFather(int father) {
        this.father = father;
    }
}

class ExplicitSon extends ExplicitFather {

    int son;

    public ExplicitSon(int father, int son) {
        // 先调用父类的有参构造方法
        // jvm是通过super实参列表的类型
        // super();
        //super(father);
        this.son = son;
    }

}
