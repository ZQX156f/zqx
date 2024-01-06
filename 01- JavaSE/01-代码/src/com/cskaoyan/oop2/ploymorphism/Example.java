package com.cskaoyan.oop2.ploymorphism;

/*
     科学家要收集动物的叫声去研究，先要收集猫，狗两种动物的叫声研究。
     随后又扩展到其它动物，最后又需要研究人类。

     1. 需求变了， 要研究新的动物，鸭子
     2. 需求又变了，要研究人的声音，你得让一个人疯狂的工作，发出叫声

     引用名 instanceof 类名
     判断引用变量所指向的对象 是否真的是 目标类对象
     结果: true 是
          false 不是


     不管什么类型的引用变量 赋值 null

     null instanceof 类名 结果永远是false
 */
public class Example {

    public static void main(String[] args) {

        Cat cat = new Cat();
        //collectCatVoice(cat);

        Dog dog = new Dog();
        //collectDogVoice(dog);


        //collectAnimalVoice(cat);
        //collectAnimalVoice(dog);

        // 当需求发生变化
        Duck duck = new Duck();
        //collectAnimalVoice(duck);


        Human human = new Human();
        //collectAnimalVoice(human);


        Human h = null;
        duck = null;

        System.out.println( null instanceof Human);

        System.out.println(h instanceof Human);

    }



    public static void collectDogVoice(Dog dog) {

        // 发出狗的声音
        dog.shot();

        // 收集并研究
    }

    public static void collectCatVoice(Cat cat) {




        // 发出叫声
        cat.shot();

        // 收集声音并研究
    }

    /*
         将参数类型变成父类类型
     */
    public static void collectAnimalVoice(Animal animal) {

        // 先让人工作
        if (animal instanceof Human) {
            // 如果animal 指向的实际是Human对象
            Human human = (Human) animal;
            human.work();
        }


        //animal.work();



        // 让动物发出叫声(多态来保证，传什么动物发出什么动物的叫声)
        animal.shot();

        // 收集并研究声音
    }
}

class Animal {

    public void shot() {
        System.out.println("动物的声音");
    }
}

class Cat extends Animal {

    @Override
    public void shot() {
        System.out.println( "喵喵喵");
    }

}

class Dog extends Animal {
    @Override
    public void shot() {
        System.out.println( "汪汪汪");
    }
}

class Duck extends Animal {

    @Override
    public void shot() {
        System.out.println("嘎嘎嘎");
    }
}

class Human extends Animal {

    @Override
    public void shot() {
        System.out.println("啊~");
    }

    public void work() {
        System.out.println("福报，996, 我工作，我开心");
    }
}
