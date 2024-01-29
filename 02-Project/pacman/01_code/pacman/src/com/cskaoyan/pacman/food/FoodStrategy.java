package com.cskaoyan.pacman.food;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.status.GameStatus;

/**
 * @ClassName FoodStrategy
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 10:35
 * @Version V1.0
 **/
public interface FoodStrategy {

    Coordinate getFoodCoordinate(GameStatus gameStatus);
}
