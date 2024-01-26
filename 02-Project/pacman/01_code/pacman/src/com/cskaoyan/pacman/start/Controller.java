package com.cskaoyan.pacman.start;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.draw.GameFrame;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Ghost;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.status.RunStatus;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Controller
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 10:38
 * @Version V1.0
 **/
public class Controller {

    //游戏的运行状态，默认是运行
    private RunStatus status = RunStatus.RUN;

    //游戏的提示信息
    private String message;

    //当前游戏的状态，比如pacman、幽灵所在的位置
    private GameStatus gameStatus;

    //frame是渲染页面所必须的，了解即可
    //课后大家可以将项目的基准代码先自己敲一遍，但是如果里面涉及的是绘图相关的代码，不用去研究
    //直接复制参考代码即可
    private GameFrame gameFrame;

    public void start() {

        //初始化游戏状态；里面某张地图来进行初始化
        this.gameStatus = new GameStatus(GameParameter.gameMap);
        //渲染页面需要用到的数据
        this.gameFrame = new GameFrame(gameStatus);

        redraw();
    }

    private void redraw() {
        int sleepTime = GameParameter.timedRedraw;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean pacmanMove = true;
        while (true){
            //幽灵和pacman进行交替的运动
            if(gameStatus.ghost != null  && !pacmanMove){
                gameStatus.ghostMove();
            }else {
                gameStatus.pacmanMove();
            }
            pacmanMove = !pacmanMove;

            //窗体重绘
            gameFrame.repaint();

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //游戏状态检查
            gameStatusCheck(gameStatus);

            switch (status){
                case RUN:
                    this.status = RunStatus.RUN;
                    break;

                case OVER:
                    if (message != null && message.length() > 1){
                        JOptionPane.showMessageDialog(null, new JLabel(message));
                    }
                    try {
                        Thread.sleep(200);
                        gameFrame.repaint();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 游戏结束: 关闭窗体, 把当前这次游戏结束
                    gameFrame.close();
                    return;
            }
        }
    }

    private void gameStatusCheck(GameStatus gameStatus) {
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;
        if (gameStatus.walls[pacmanCoordinate.x][pacmanCoordinate.y]){
            this.message = "<html><h1>pacman撞墙了 </h2></html>";
            this.status = RunStatus.OVER;
            return;
        }


        // 把幽灵的坐标取出来, 检测这个坐标位置是否有墙
        Ghost ghost = gameStatus.ghost;
        if(ghost != null){
            Coordinate ghostCoordinate = ghost.coordinate;

            if (gameStatus.walls[ghostCoordinate.x][ghostCoordinate.y]){
                this.message = "<html><h1>幽灵撞墙了</h2></html>";
                this.status = RunStatus.OVER;
                return;
            }

            // 判断幽灵是否和pacman相遇
            if (ghostCoordinate.equals(pacmanCoordinate)){

                this.message = "<html><h1>你的pacman被吃掉了</h2></html>";
                this.status = RunStatus.OVER;
                return;
            }
        }


        // 判断pacman是否是遇到食物 -> 食物吃掉
        if (gameStatus.foods[pacmanCoordinate.x][pacmanCoordinate.y]){

            gameStatus.foods[pacmanCoordinate.x][pacmanCoordinate.y] = false;
//            scoreTag += Parameters.foodScores;
            gameStatus.availableFoods--;

            this.status = RunStatus.RUN;
            return;
        }

        // 食物是否吃完了
        if (gameStatus.availableFoods < 1){
            this.message = "<html><h1>食物吃完, 游戏结束</h2></html>";
            this.status = RunStatus.OVER;
        }
    }

}
