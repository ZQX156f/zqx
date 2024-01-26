package com.cskaoyan.pacman.start;

/**
 * @ClassName GameStartup
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 10:37
 * @Version V1.0
 **/
public class GameStartup {

    public static void main(String[] args) {
        //定义了一个控制器对象
        Controller controller = new Controller();
        //调用了控制器的start方法运行了当前游戏
        controller.start();
    }
}
