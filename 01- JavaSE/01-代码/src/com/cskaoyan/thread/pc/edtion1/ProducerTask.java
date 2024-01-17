package com.cskaoyan.thread.pc.edtion1;

import java.util.Random;

/*
        生产者任务
 */
public class ProducerTask implements Runnable{

    Food[] bill = {new Food("杭州小笼包",2), new Food("蟹黄包", 5),
    new Food("狗不理", 20), new Food("灌汤包", 3)};

    Box box;

    public ProducerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (box) {

                if (!box.isEmpty()) {
                    // 蒸笼不空，阻止自己
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else  {
                    // 蒸笼为空, 随机向蒸笼中放入包子
                    Random random = new Random();

                    // 产生一个[0, bill.length-1]
                    int randomIndex = random.nextInt(bill.length);
                    box.setFood(bill[randomIndex]);

                    // 通知吃包子的人，来吃包子
                    box.notify();
                }
            }

        }
    }
}
