package com.cskaoyan.thread.pc.edtion1;

/*
     消费者任务

 */
public class ConsumerTask implements Runnable{


    Box box;

    public ConsumerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            // 因为生产者和消费者都访问同一个蒸笼对象，也可以用蒸笼对象最为同一把锁对象
            synchronized (box) {

                // 判断蒸笼是否为空
                if (box.isEmpty()) {
                    // 蒸笼为空，阻止自己
                    try {
                        box.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    // 取包子出来吃
                    box.eatFood();

                    // 通知做包子的人，继续做包子
                    box.notify();

                }

            }
        }





    }
}
