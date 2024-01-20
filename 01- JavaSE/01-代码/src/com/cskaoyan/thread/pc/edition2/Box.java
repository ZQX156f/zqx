package com.cskaoyan.thread.pc.edition2;

/*
      智能蒸笼:
      1. 生产者线程和消费者线程 对于蒸笼的互斥访问
         只需要将setFood 和 eatFood 变成同步方法即可

      2.

 */
public class Box {

    // 蒸笼中的包子
    Food food;

    int i;

    /*
        生产者调用的方法，运行在生产者线程中
     */
    public synchronized void setFood(Food food) {
        // this
        if (this.food != null) {
            // 蒸笼里有包子
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 蒸笼为空
            this.food = food;
            System.out.println(Thread.currentThread().getName() + "做了" + food);
            // 通知消费者吃包子
            this.notifyAll();
        }


    }

    /*
        消费者调用的方法，运行在消费者线程
     */
    public synchronized void eatFood() {

        if (food == null) {
            // 蒸笼为空
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 蒸笼不空
            System.out.println(Thread.currentThread().getName() + "吃了" + food);
            this.food = null;

            // 通知做包子，继续做包子
            this.notifyAll();
        }

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


