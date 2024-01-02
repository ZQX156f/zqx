package com.cskaoyan.oop.constructor;

public class EX2 {

    public static void main(String[] args) {

        Plant plant = new Plant("豌豆射手", 90, 1000, 100);

        Zombie zombie = new Zombie("巨人僵尸", 10000, 200, 100);

        // 让植物对象的plantZ，指向要攻击的僵尸
        plant.plantZ = zombie;

        // 让僵尸对象的zombieP, 指向要攻击的植物
        zombie.zombieP = plant;

        // 植物的攻击方法
        plant.attack();


        // 僵尸攻击植物
        zombie.attack();
    }
}

class Plant {

    String name;
    int price;
    int hp;
    // 攻击力
    int damage;

    // 一个植物正在攻击的僵尸
    Zombie plantZ;

    public Plant() {

    }

    public Plant(String name, int price, int hp, int damage) {
        this.name = name;
        this.price = price;
        this.hp = hp;
        this.damage = damage;
    }


    // 行为
    public void attack() {
        System.out.println(this.name + "正在攻击" + plantZ.name);
    }

    public void beAttacked() {
        System.out.println(name + "正在被" + plantZ.name + "攻击,现在还剩下" + (hp - plantZ.damage));
    }

}

class Zombie {

    String name;
    int hp;
    // 攻击力
    int damage;
    double speed;

    // 表示僵尸正在攻击的植物
    Plant zombieP;

    public Zombie() {

    }

    public Zombie(String name, int hp, int damage, double speed) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }

    // 行为
    public void attack() {
        System.out.println(name + "正在攻击" + zombieP.name);
    }

    public void beAttacked() {
        System.out.println(name + "正在被" + zombieP.name + "攻击,现在还剩下" + (hp - zombieP.damage));
    }

    public void move() {
        System.out.println(name + "正在以" + speed + "的速度,接近你的脑子~~");
    }

    public void eat() {
        System.out.println(name + "吃掉了你的脑子~真香~");
    }
}

