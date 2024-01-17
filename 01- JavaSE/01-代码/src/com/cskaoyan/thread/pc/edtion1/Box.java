package com.cskaoyan.thread.pc.edtion1;

/*
    蒸笼

 */
public class Box {

    // 表示蒸笼中的包子
    Food food;

    int i;

    /*
        生产者使用
     */
    public void setFood(Food food) {

        this.food = food;
        System.out.println(Thread.currentThread().getName() + "做了" + food);
    }

    /*
         给消费者使用
     */
    public void eatFood () {
        System.out.println(Thread.currentThread().getName() + "吃了" + food);
        // 吃掉了包子
        this.food = null;

    }

    /*
        判断蒸笼是否为空
     */
    public boolean isEmpty () {
        return food == null;
    }



}


/*
     包子
 */
class Food {

    // 包子的名称
    private String name;
    // 包子的价格
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
