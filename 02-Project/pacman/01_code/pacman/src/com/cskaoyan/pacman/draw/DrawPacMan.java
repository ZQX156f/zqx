package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.status.GameStatus;

import java.awt.*;

/**
 * @ClassName DrawPacMan
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:14
 * @Version V1.0
 **/
public class DrawPacMan implements DrawComponent{
    @Override
    public void draw(Graphics g, GameStatus status) {
        Position pacmanPosition = status.pacMan.routerPlan != null && status.pacMan.routerPlan.peek() != null ? status.pacMan.routerPlan.peek() : Position.LEFT;
        int ratio = GameParameter.ratio;
        int angle = 0;
        int eyeX = 0;
        int eyey = 0;

        switch (pacmanPosition){
            case RIGHT :
                angle += 90*0 + 5;
                eyeX = (int) (ratio*0.7);
                eyey = (int) (ratio*0.2);
                break;
            case DOWN :
                angle += 90*1 + 4;
                eyeX = (int) (ratio*0.2);
                eyey = (int) (ratio*0.7);
                break;
            case LEFT:
                angle += 90*2;
                eyeX = (int) (ratio*0.2);
                eyey = (int) (ratio*0.2);
                break;
            case UP:
                angle += 90*3 - 4;
                eyeX = (int) (ratio*0.7);
                eyey = (int) (ratio*0.2);
                break;
            default:
                angle += 90*0 + 5;
                eyeX = (int) (ratio*0.7);
                eyey = (int) (ratio*0.2);
        }

        int xIndex = status.pacMan.coordinate.x;
        int yIndex =status.pacMan.coordinate.y;

        int x = xIndex*ratio;
        int y = (status.walls[0].length-1-yIndex) * ratio;

        g.setColor(new Color(GameParameter.pacmanColor));

        //if (bool){
            g.fillArc(x, y, ratio, ratio,
                    (int)(angle*Math.PI),(int)((100-(1.0/12))*Math.PI));
        //}else {
          //  g.fillOval(x, y, ratio, ratio);
        //}
        //bool = !bool;

        g.setColor(new Color(GameParameter.pacmanEyesColor));
        g.fillOval(x+ eyeX, y+ eyey, ratio/8, ratio/8);

    }
}
