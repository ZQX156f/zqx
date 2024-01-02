package com.cskaoyan.oop.constructor;

public class EX1 {

    public static void main(String[] args) {

        Legend legend = new Legend("Galen", "沉默打击", "勇气", "爱的魔力转圈圈", "大宝剑");

        // 模拟战斗行为
        legend.fight();


    }
}

// 英雄类
class Legend {
    String name;
    String skillQ;
    String skillW;
    String skillE;
    String skillR;

    /*
        定义构造器,从代码规范上来说,构造器写在
        成员变量的下面
        成员方法的上面
        而且都要写在一起(实际上所有构造方法重载的方法都应该写在一起)
        写在一起的顺序: 可以按照参数个数的多少去排列,个数少的在上面,多的在下面
      */
    public Legend() {
    }

    public Legend(String name, String skillQ, String skillW, String skillE, String skillR) {
        this.name = name;
        this.skillQ = skillQ;
        this.skillW = skillW;
        this.skillE = skillE;
        this.skillR = skillR;
    }

    public void fight() {
        System.out.println("名字为" + name + "的英雄,正在使用"+skillR+"技能战斗!");
    }

}
