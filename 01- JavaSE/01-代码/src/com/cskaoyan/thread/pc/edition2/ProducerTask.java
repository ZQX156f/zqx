package com.cskaoyan.thread.pc.edition2;



import java.util.Random;

/*
     生产者任务
 */
public class ProducerTask implements Runnable{
    Food[] bill = {new Food("杭州小笼包",2), new Food("蟹黄包", 5),
            new Food("狗不理", 20), new Food("灌汤包", 3)};

    Box box;

    Random random;

    public ProducerTask(Box box) {
        random = new Random();

        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            int randomIndex = random.nextInt(bill.length);
            // 放入蒸笼
            box.setFood(bill[randomIndex]);
        }
    }
}
