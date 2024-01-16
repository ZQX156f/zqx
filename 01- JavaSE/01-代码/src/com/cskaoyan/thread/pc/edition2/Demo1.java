package com.cskaoyan.thread.pc.edition2;

/*

        为什么当存在多个生产者和多个消费者的时候，唤醒使用notify方法阻塞？

        c1,c2,p1,p2  都start
        c1抢到 > 进入sync , 空的, wait ,释放锁
        c2抢到  > 进入sync,空的, wait , 释放锁
        p1抢到  > 进入sync, 空的可以生产, notify()唤醒p2 , 退出sync,释放锁
        p2抢到  > 进入Sync， 不空，wait(), 释放锁
        p1抢到 > 近Sync, 不空， wait(), 释放锁

        将notify ——> notifyAll

 */
public class Demo1 {

    public static void main(String[] args) {

        Box box = new Box();

        // 创建任务对象
        ProducerTask producerTask = new ProducerTask(box);
        ConsumerTask consumerTask = new ConsumerTask(box);


        new Thread(producerTask).start();
        new Thread(producerTask).start();
        new Thread(consumerTask).start();
        new Thread(consumerTask).start();

    }
}
