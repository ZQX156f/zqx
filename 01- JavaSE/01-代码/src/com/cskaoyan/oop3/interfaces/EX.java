package com.cskaoyan.oop3.interfaces;

/*
   教练（Coach）和运动员（Sportsman）案例

  小试牛刀请用所学知识分析：这个案例中有哪些抽象类，哪些接口，哪些具体类。
  现在有乒乓球运动员和篮球运动员，乒乓球教练和篮球教练。
  为了能够出国交流，跟乒乓球相关的人员都需要学习英语。

   教练: 抽象类
      train() 行为
      name 属性
      bonus 奖金
     a. 乒乓球教练   train() 乒乓球内容
     b. 篮球教练    train()  篮球内容

   运动员: 抽象类
     match() 比赛行为
     name 属性
     int  age
     a. 乒乓球运动员   match() 比的是乒乓球
     b. 篮球运动员     match() 比的是篮球

     定义一个接口描述学习英语的行为


 */
public class EX {
}

interface ISpecialSkill {
    // 声明学英语的行为
    void learnEnglish();
}

abstract class Coach {
  String name;

  double bonus;

    public Coach(String name, double bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public abstract void train();
}

abstract class Player {
    String name;
    int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public abstract void match();
}

// 具体子类
class BasketballCoach extends Coach {

    public BasketballCoach(String name, double bonus) {
        super(name, bonus);
    }

    @Override
    public void train() {
        System.out.println("训练篮球");
    }
}

class TableTennisCoach extends Coach implements ISpecialSkill {

    public TableTennisCoach(String name, double bonus) {
        super(name, bonus);
    }

    @Override
    public void train() {
        System.out.println("训练乒乓球");
    }

    @Override
    public void learnEnglish() {
        System.out.println("乒乓球教练学英语");
    }
}

class BasketballPlayer extends Player {

    public BasketballPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void match() {
        System.out.println("篮球比赛");
    }
}

class TableTennisPlayer extends Player implements ISpecialSkill {

    public TableTennisPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void match() {
        System.out.println("乒乓球比赛");
    }

    @Override
    public void learnEnglish() {
        System.out.println("乒乓球运行员学英语");
    }
}
