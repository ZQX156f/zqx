package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.status.GameStatus;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


/**
 * @ClassName GamePanel
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 12:01
 * @Version V1.0
 **/
public class GamePanel extends JPanel {

    public int xNum;
    public int yNum;
    public int ratio;
    public GameStatus gameStatus;

    private LinkedList<DrawComponent> components = new LinkedList<>();


    public GamePanel(GameStatus gameStatus) {
        this.xNum = gameStatus.xNum;
        this.yNum = gameStatus.yNum;
        this.ratio = GameParameter.ratio;
        this.gameStatus = gameStatus;

        registerComponent();
    }

    private void registerComponent() {
        components.offer(new DrawPacManTraversedPath());
        components.offer(new DrawPacManRoutePath());
        //如果不设定先后顺序，则pacman撞墙会变成pacman被墙吸收
        components.offer(new DrawWall());
        components.offer(new DrawPacMan());
        components.offer(new DrawFood());
        components.offer(new DrawGhost());
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < components.size(); i++) {
            DrawComponent drawComponent = components.get(i);
            //搜索路径、行进路径需要判断一下前置条件
            if(drawComponent instanceof DrawPacManTraversedPath){
                if(gameStatus.pacMan == null || gameStatus.pacMan.pacmanTraversedNodes == null || gameStatus.pacMan.pacmanTraversedNodes.size() <= 0){
                    continue;
                }
            }
            if(drawComponent instanceof DrawPacManRoutePath){
                if(gameStatus.pacMan.routerPlan == null || !GameParameter.visiblePath){
                    continue;
                }
            }

            //绘制
            drawComponent.draw(g, gameStatus);

        }
    }
}
