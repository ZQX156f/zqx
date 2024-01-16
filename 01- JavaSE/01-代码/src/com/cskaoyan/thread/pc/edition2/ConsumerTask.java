package com.cskaoyan.thread.pc.edition2;

public class ConsumerTask implements Runnable{

    Box box;

    public ConsumerTask(Box box) {
        this.box = box;
    }

    @Override
    public void run() {

        while (true) {
            // 消费包子
            box.eatFood();
        }

    }
}
