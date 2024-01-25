package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.status.GameStatus;

import java.awt.*;

/**
 * @ClassName DrawWall
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:14
 * @Version V1.0
 **/
public class DrawWall implements DrawComponent{
    @Override
    public void draw(Graphics g, GameStatus status) {
        boolean[][] walls = status.walls;

        int xNum = walls.length;
        int yNum = walls[0].length;
        int ratio = GameParameter.ratio;

        for (int x = 0; x < xNum; x++) {
            for (int y = 0; y < yNum; y++) {
                if(walls[x][y]){
                    g.setColor(new Color(GameParameter.wallColor));
                    g.fillRect(x * ratio, (yNum - 1 - y) * ratio, ratio, ratio);
                }
            }
        }

    }
}
