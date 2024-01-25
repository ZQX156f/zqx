package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.awt.*;

/**
 * @ClassName PacManRoutePath
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:09
 * @Version V1.0
 **/
public class DrawPacManRoutePath implements DrawComponent {
    @Override
    public void draw(Graphics g, GameStatus status) {
        Node mid = status.pacMan.routerPaint;

        int yNum = status.walls[0].length;
        int ratio = GameParameter.ratio ;

        while (mid != null){
            int x =  mid.coordinate.x  * ratio;
            int y =  (yNum - mid.coordinate.y-1) * ratio;

            g.setColor(new Color(GameParameter.pathColor));
            g.fillRect(x,y , ratio , ratio);

            mid = mid.preNode;
        }
    }
}
