package com.cskaoyan.oop2.extend.override;


/*

      和前面访问成员变量一样，在研究对象名点访问成员方法机制时，我们主要探究两个方向：

        1. 访问范围，究竟能够访问到哪些成员方法？根据什么来决定？
        2. 访问结果，如果是父子类同名成员方法，那么结果是什么？根据什么来决定？

        首先是 对象名点访问成员方法，对象的由来，可以有三种方式：
        1. 创建父类对象,用父类引用接收，用对象名点访问。
        2. 创建子类对象,用子类引用接收，用对象名点访问。
        3. 创建子类对象,用父类引用接收，用对象名点访问。

        访问范围机制: 访问到的成员方法的范围，由引用变量的类型决定
        访问结果: 访问到的结果由引用变量，实际所指向的类型决定
 */
public class Demo1 {

    public static void main(String[] args) {

        // 1. 创建父类对象,用父类引用接收，用对象名点访问
        OverrideFather overrideFather = new OverrideFather();
        overrideFather.fatherMethod();



        // a. 访问范围 (父)
        //overrideFather.fatherMethod();
        //overrideFather.sameMethod();
        // 访问不到子类成员
        //overrideFather.sonMethod();

        // b. 访问结果
        //overrideFather.sameMethod(); // father


        // 2. 创建子类对象,用子类引用接收，用对象名点访问。

        // a. 访问范围 （父 + 子）
        OverrideSon overrideSon = new OverrideSon();
        //overrideSon.sonMethod();
        //overrideSon.sameMethod();
        //overrideSon.fatherMethod();

        // b. 访问结果
        //overrideSon.sameMethod(); // son

        // 3. 创建子类对象,用父类引用接收，用对象名点访问。
        OverrideFather father = new OverrideSon();

        // a. 访问范围 (父)
        //father.sameMethod();
        //father.fatherMethod();
        // 访问不到
        //father.sonMethod();

        // b. 访问结果
        //father.sameMethod(); // son



        OverrideSon son = new OverrideSon();

        // 在子类方法中，调用同名方法
        //son.sonMethod();

        //son.fatherMethod();

    }
}

class OverrideFather {

    public void sameMethod() {
        System.out.println("father");
    }

    public void fatherMethod() {
        sameMethod();
    }

}


class OverrideSon extends OverrideFather {

    public void sameMethod() {
        System.out.println("son");
    }

    public void sonMethod() {

        // 在子类中，可以通过super调用到父类中定义的同名方法
        super.sameMethod();


        sameMethod();
    }
}
