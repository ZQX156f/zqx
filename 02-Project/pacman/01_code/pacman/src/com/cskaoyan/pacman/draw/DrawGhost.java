package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Ghost;
import com.cskaoyan.pacman.status.GameStatus;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @ClassName DrawGhost
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:18
 * @Version V1.0
 **/
public class DrawGhost implements DrawComponent{
    @Override
    public void draw(Graphics g, GameStatus status) {
        int ratio = GameParameter.ratio;

        Ghost ghost = status.ghost;

            Coordinate coordinate = ghost.coordinate;
            int xIndex = coordinate.x;
            int yIndex = coordinate.y;

            int x = xIndex*ratio;
            int y = (status.walls[0].length-1-yIndex) * ratio;

            String path = "imgs/monster.png";

            BufferedImage read = null;
            try {
                read = ImageIO.read(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            g.drawImage(read,x,y,ratio,ratio,null);
        }
}
