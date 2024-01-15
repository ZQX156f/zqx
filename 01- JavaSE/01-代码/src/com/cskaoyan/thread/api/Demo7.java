package com.cskaoyan.thread.api;

/*

    public final void setDaemon(boolean on)

      将该线程标记为 守护线程 或 用户线程。
      on - 如果为 true，则将该线程标记为守护线程。

      执行特征：当正在运行的线程都是守护线程时，Java 虚拟机退出。

      使用场景：
         比如说，我们jvm垃圾回收器，就运行在守护中

      注意事项：
        该方法必须在启动线程前调用。

 */
public class Demo7 {

    public static void main(String[] args) {

        DaemonThread daemonThread = new DaemonThread();

        // 将线程标记为守护线程
        daemonThread.setDaemon(true);
        // 启动子线程
        daemonThread.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("main: i = " + i);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

class DaemonThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": i = " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
