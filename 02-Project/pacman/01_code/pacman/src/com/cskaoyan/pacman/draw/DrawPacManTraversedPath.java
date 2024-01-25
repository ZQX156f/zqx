package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.status.GameStatus;

import java.awt.*;
import java.util.LinkedHashSet;

/**
 * @ClassName PacManTraversedPath
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:07
 * @Version V1.0
 **/
public class DrawPacManTraversedPath implements DrawComponent {
    @Override
    public void draw(Graphics g, GameStatus status) {
        LinkedHashSet<Coordinate> coordinates = status.pacMan.pacmanTraversedNodes;

        int yNum = status.walls[0].length;
        int ratio = GameParameter.ratio ;

        for (Coordinate coordinate : coordinates) {

            int x =  coordinate.x  * ratio;
            int y =  (yNum - coordinate.y-1) * ratio;

            g.setColor(new Color(GameParameter.searchedModuleColor));
            g.fillRect(x,y , ratio , ratio);
        }

    }
}
