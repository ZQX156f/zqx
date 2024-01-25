package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.status.GameStatus;

import java.awt.*;

/**
 * @ClassName GameComponent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:03
 * @Version V1.0
 **/
public interface DrawComponent {

    void draw(Graphics g, GameStatus status);

}
