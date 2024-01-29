package com.cskaoyan.pacman.distance;

import com.cskaoyan.pacman.model.Coordinate;

/**
 * @ClassName ManhattanDistance
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 11:07
 * @Version V1.0
 **/
public class ManhattanDistance implements MathDistance {
    @Override
    public double getDistance(Coordinate c1, Coordinate c2) {

        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }
}
