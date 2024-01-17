package com.cskaoyan.work;

public class DemoThread {

    /**
     *
     * 既然是两个线程交替打印，那就是一个线程打印奇数，一个线程打印偶数
     * 奇数线程打印奇数，然后让被打印数字增1
     * 偶数线程打印偶数，然后让被打印数字增1
     * 知道打印到题目中数字的上界99
     */
    public static void main(String[] args) {

        PrintNumber printNumber = new PrintNumber(99);


        // 创建任务对象
        NewOddTask oddTask = new NewOddTask(printNumber);
        NewEvenTask evenTask = new NewEvenTask(printNumber);

        new Thread(oddTask).start();
        new Thread(evenTask).start();

    }
}

class PrintNumber {

    // 代表打印的数据
    private int i = 0;

    //指定被打印数字的上线，在题目中upBound的取值为99，只要打印到99即可
    private int upBound;
    public PrintNumber(int upBound) {
        this.upBound = upBound;
    }
 /*
     让被打印数字增1
  */

    public void add() {
        i++;
    }

 /*
     获取打印数字的上界
  */

    public int getUpBound() {
        return upBound;
    }

 /*
     获取被打印数字当前的值
  */

    public int value() {
        return i;
    }

}



abstract class PrintTask implements Runnable {

    PrintNumber printNumber;

    public PrintTask(PrintNumber printNumber) {
        this.printNumber = printNumber;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (printNumber) {
                // 打印
                if (printNumber.value() > printNumber.getUpBound()) {
                    // 如果超过了要打印的数值的上界，退出
                    break;
                }

                if (!shouldPrint(printNumber.value())) {
                    // 待打印的值是偶数

                    try {
                        printNumber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    // 是奇数

                    System.out.println(Thread.currentThread().getName() + ": i = " + printNumber.value());
                    // +1
                    printNumber.add();

                    // 唤醒偶数线程
                    printNumber.notifyAll();

                }


            }


        }
    }


    public abstract boolean shouldPrint(int number);
}

class NewOddTask extends PrintTask {

    public NewOddTask(PrintNumber printNumber) {
        super(printNumber);
    }

    @Override
    public boolean shouldPrint(int number) {
        return number % 2 != 0;
    }
}

class NewEvenTask extends PrintTask {

    public NewEvenTask(PrintNumber printNumber) {
        super(printNumber);
    }

    @Override
    public boolean shouldPrint(int number) {
        return number % 2 == 0;
    }
}


/*
    奇数线程
 */
class OddTask implements Runnable {

    PrintNumber printNumber;

    public OddTask(PrintNumber printNumber) {
        this.printNumber = printNumber;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (printNumber) {
                // 打印
                if (printNumber.value() > printNumber.getUpBound()) {
                    // 如果超过了要打印的数值的上界，退出
                    break;
                }

                if (printNumber.value() % 2 == 0) {
                    // 待打印的值是偶数

                    try {
                        printNumber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                   // 是奇数

                    System.out.println(Thread.currentThread().getName() + ": i = " + printNumber.value());
                    // +1
                    printNumber.add();

                    // 唤醒偶数线程
                    printNumber.notifyAll();

                }


            }


        }

    }
}

/*
      偶数线程
 */
class EvenTask implements Runnable {


    PrintNumber printNumber;

    public EvenTask(PrintNumber printNumber) {
        this.printNumber = printNumber;
    }

    @Override
    public void run() {


        while (true) {

            synchronized (printNumber) {
                // 打印
                if (printNumber.value() > printNumber.getUpBound()) {
                    // 如果超过了要打印的数值的上界，退出
                    break;
                }

                if (printNumber.value() % 2 != 0) {
                    // 待打印的值是奇数

                    try {
                        printNumber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    // 是偶数

                    System.out.println(Thread.currentThread().getName() + ": i = " + printNumber.value());
                    // +1
                    printNumber.add();

                    // 唤醒偶数线程
                    printNumber.notifyAll();

                }


            }


        }

    }
}
