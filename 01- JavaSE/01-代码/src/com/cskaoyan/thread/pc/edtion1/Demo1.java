package com.cskaoyan.thread.pc.edtion1;

import javax.swing.plaf.TableHeaderUI;

/*

     运行生产者-消费第一个版本的代码
 */
public class Demo1 {

    public static void main(String[] args) {
        // 生产者和消费者所共同访问的蒸笼对象
        Box box = new Box();

        // 创建任务对象
        ConsumerTask consumerTask = new ConsumerTask(box);
        ProducerTask producerTask = new ProducerTask(box);


        // 创建线程并启动
        new Thread(consumerTask).start();
        new Thread(producerTask).start();


    }
}
