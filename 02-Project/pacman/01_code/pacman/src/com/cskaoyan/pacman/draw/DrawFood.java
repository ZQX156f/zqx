package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.status.GameStatus;

import java.awt.*;

/**
 * @ClassName DrawFood
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:17
 * @Version V1.0
 **/
public class DrawFood implements DrawComponent{
    @Override
    public void draw(Graphics g, GameStatus status) {
        boolean[][] foods = status.foods;

        int xNum = foods.length;
        int yNum = foods[0].length;
        int ratio = GameParameter.ratio ;
        int foodratio = GameParameter.foodRatio;


        for (int xcol = 0; xcol < xNum; xcol++) {
            for (int yrow = 0; yrow < yNum; yrow++) {

                if (foods[xcol][yrow]){

                    int x = xcol*ratio;
                    int y = (yNum-1-yrow) * ratio;

                    g.setColor(new Color(GameParameter.foodColor));
                    g.fillOval(
                            x+(ratio/2)-(foodratio/2), y+(ratio/2)-(foodratio/2),
                            foodratio, foodratio);
                }

            }
        }

    }
}
