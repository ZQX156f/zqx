package com.cskaoyan.pacman.food;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.status.GameStatus;

/**
 * @ClassName DoubleCircularFoodStrategy
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 10:35
 * @Version V1.0
 **/
public class DoubleCircularFoodStrategy implements FoodStrategy{
    @Override
    public Coordinate getFoodCoordinate(GameStatus gameStatus) {
        //但是使用这种方式，只是在双重for循环去查找食物，那么可能会出现一种情况：
        //离pacman最近的一个事物，被pacman所无视，去找一个相对比较远的食物去吃
        Coordinate foodCoordinate = null;
        boolean[][] foods = gameStatus.foods;
        for (int x = 0; x < foods.length; x++) {
            for (int y = 0; y < foods[x].length; y++) {
                if(foods[x][y]){
                    foodCoordinate = new Coordinate(x, y);
                }
            }
        }
        return foodCoordinate;
    }
}
