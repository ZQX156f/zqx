package com.cskaoyan.oop2.extend.character;

/*
        java语言实现的继承有特征: 单重继承
        extends关键字之后只能跟一个类的类名: 一个类只能有一个直接父类
 */
public class Demo1 {

    public static void main(String[] args) {

        GranSon1 granSon1 = new GranSon1();

        // 访问直接父类中的成员
        System.out.println(granSon1.son);
        // 访问爷爷类中的成员
        System.out.println(granSon1.father);

    }
}

class A {}

class Father {

    int father;

}

class Son extends Father {

    int son;

}


class GranSon1 extends Son {
    int grandSon;
}





class GrandSon2 extends Son {

}
