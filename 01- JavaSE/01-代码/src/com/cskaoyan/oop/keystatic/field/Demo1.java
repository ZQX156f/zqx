package com.cskaoyan.oop.keystatic.field;

/*
      静态成员变量语法:
       [访问权限修饰符] static 数据类型 变量名;

       使用与特点:
        - 和普通成员变量一样,都具有默认值（默认值和普通成员变量是一样的）
        - 静态成员变量属于类的，完全不需要创建对象使用。(被static修饰的成员就可以被该类的所有对象所共享)
        - 访问和使用静态成员变量不推荐使用"对象名."，而应该使用"类名."！
        - 静态成员变量的访问/赋值/使用都不依赖于对象, 而是依赖于类

      注意事项:
        只存在静态成员变量，不存在"静态局部变量"
 */
public class Demo1 {

    public static void main(String[] args) {

        // 定义一个计数器
        //int count = 0;

        Player p1 = new Player("Kobe");
        p1.shot();
        // 第一种方式访问静态变量
        //p1.count += 3;

        // 第二种方式访问静态变量
        Player.count += 3;
        //System.out.println("分数: " + Player.count);

        Player p2 = new Player("James");
        p2.shot();
        //p2.count += 3;
        // 第二种方式访问静态变量
        Player.count += 3;
        //System.out.println("分数: " + Player.count);

        Player p3 = new Player("Stephen");
        p3.shot();
        //p3.count += 3;

        // 第二种方式访问静态变量
        Player.count += 3;
        //System.out.println("分数: " + Player.count);

    }
}

class Player {
    // 定义成员变量
    String name;

    // 被static修饰的所有对象被该类的所有对象所共享
    static int count;

    public Player(String name) {
        this.name = name;
    }

    // 定义成员方法
    public void shot() {
        // static不能修饰局部变量
        // static int a = 1;

        System.out.println(name + "进球了!");
    }
}
