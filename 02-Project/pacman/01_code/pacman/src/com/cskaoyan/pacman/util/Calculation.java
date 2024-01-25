package com.cskaoyan.pacman.util;


import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;

/**
 * @ClassName Calculation
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/10/10 17:49
 * @Version V1.0
 **/
public class Calculation {
    public static Coordinate getCoordinate(Coordinate coordinate, Position direction) {
        int x = coordinate.x;
        int y = coordinate.y;
        Coordinate nextCoordinate = null;
        switch (direction){
            case LEFT:
                nextCoordinate = new Coordinate(x - 1, y);
                break;
            case RIGHT:
                nextCoordinate = new Coordinate(x + 1, y);
                break;
            case UP:
                nextCoordinate = new Coordinate(x, y + 1);
                break;
            case DOWN:
                nextCoordinate = new Coordinate(x, y - 1);
                break;
            case STOP:
                nextCoordinate = new Coordinate(x, y);
                break;
            default:
        }
        return nextCoordinate;
    }
}
