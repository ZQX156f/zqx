package com.cskaoyan.oop.keystatic.introduction;

public class Demo1 {

    public static void main(String[] args) {
        // 定义一个计数器
        //int count = 0;

        Player p1 = new Player("Kobe");
        p1.shot();
        p1.count += 3;
        System.out.println("分数: " + p1.count);

        Player p2 = new Player("James");
        p2.shot();
        p2.count += 3;
        System.out.println("分数: " + p2.count);

        Player p3 = new Player("Stephen");
        p3.shot();
        p3.count += 3;
        System.out.println("分数: " + p3.count);
    }

}

class Player {
    // 定义成员变量
    String name;

    int count;

    public Player(String name) {
        this.name = name;
    }

    // 定义成员方法
    public void shot() {
        System.out.println(name + "进球了!");
    }
}
