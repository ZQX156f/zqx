package com.cskaoyan.pacman.distance;

import com.cskaoyan.pacman.model.Coordinate;

/**
 * @ClassName EuclideanDistance
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 11:07
 * @Version V1.0
 **/
public class EuclideanDistance implements MathDistance{
    @Override
    public double getDistance(Coordinate c1, Coordinate c2) {

        return Math.sqrt(Math.pow(c2.x - c1.x, 2) + Math.pow(c2.y - c1.y, 2));
    }
}
