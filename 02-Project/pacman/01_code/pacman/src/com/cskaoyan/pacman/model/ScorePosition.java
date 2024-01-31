package com.cskaoyan.pacman.model;

import com.cskaoyan.pacman.draw.Position;

import java.awt.*;

/**
 * @ClassName ScorePosition
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/31 10:55
 * @Version V1.0
 **/
public class ScorePosition {

    //对应的得分
    public int score;

    //这个得分对应的方向
    public Position position;

    public ScorePosition(int score, Position position) {
        this.score = score;
        this.position = position;
    }
}
