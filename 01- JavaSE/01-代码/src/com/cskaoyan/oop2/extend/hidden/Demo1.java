package com.cskaoyan.oop2.extend.hidden;


/*

   在研究 对象名点访问成员变量机制时，我们主要探究两个问题：

    1. 访问范围：不同情况下，究竟能够访问到对象中的哪些成员变量？根据什么来决定？
    2. 访问结果：如果是父子类同名成员变量，那么结果是什么？根据什么来决定？
    ---
     对象名点访问成员变量，对象的由来，可以有三种方式：
    1. 创建父类对象,用父类引用接收，用对象名点访问。
    2. 创建子类对象,用子类引用接收，用对象名点访问。
    3. 创建子类对象,用父类引用接收，用对象名点访问。

    访问范围: 之和引用变量的类型有关，引用变量的类型决定了我们能访问父类子类中的哪些成员
    访问结果: 访问到的同名成员变量值，由引用变量的类型决定


     在方法体中，我们通过变量名访问 父类子类同名成员变量值，访问的结果和方法位置有关系：
     方法在父类中访问的就是父类中的同名成员变量值，否则，访问到的就是子类中定义的同名成员变量值
 */
public class Demo1 {

    public static void main(String[] args) {


        // 1. 创建父类对象,用父类引用接收，用对象名点访问。

        // a. 研究访问范围 (父类成员)
        HiddenFather hiddenFather = new HiddenFather();
        //System.out.println(hiddenFather.same);
        //System.out.println(hiddenFather.fatherField);
        // 通过父类引用无法访问子类成员
        //System.out.println(hiddenFather.sonField);

        // b. 访问结果
        //System.out.println(hiddenFather.same); // 10


        // 2. 创建子类对象,用子类引用接收，用对象名点访问。
        HiddenSon hiddenSon = new HiddenSon();

        // a. 访问范围(父类 + 子类成员)
        //System.out.println(hiddenSon.sonField);
        //System.out.println(hiddenSon.same);
        //System.out.println(hiddenSon.fatherField);

        // b. 访问结果
        //System.out.println(hiddenSon.same); // 200

        // 3. 创建子类对象,用父类引用接收，用对象名点访问。
        HiddenFather father = new HiddenSon();

        // a. 访问范围 (父类成员)
        //System.out.println(father.fatherField);
        //System.out.println(father.same);
        // 访问不到
        //System.out.println(father.sonField);

        // b. 访问结果
        //System.out.println(father.same); // 10



        HiddenSon son = new HiddenSon();

        // 调用子类中定义的方法
        son.access();

        // 调用父类中定义的方法
        //son.accessFather();

    }

}


class HiddenFather {

    int same = 10;

    int fatherField;

    public void accessFather() {
        System.out.println(same);
    }


}

class HiddenSon extends HiddenFather {

    int same = 200;

    int sonField;

    public void access() {

        // 子类中，利用super关键字访问到父类中定义的同名成员变量值
        System.out.println(super.same);

        System.out.println(same);
    }

}
