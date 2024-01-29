package com.cskaoyan.pacman.distance;

import com.cskaoyan.pacman.model.Coordinate;

/**
 * @ClassName MathDistance
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 11:07
 * @Version V1.0
 **/
public interface MathDistance {

    double getDistance(Coordinate c1, Coordinate c2);
}
