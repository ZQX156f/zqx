package com.cskaoyan.pacman.util;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Ghost;
import com.cskaoyan.pacman.model.PacMan;
import com.cskaoyan.pacman.status.GameStatus;

/**
 * @ClassName GameStatusUtils
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/31 11:10
 * @Version V1.0
 **/
public class GameStatusUtils {
    public static GameStatus clonePacmanStatus(Coordinate newPacmanCoordinate, GameStatus origin) {
        GameStatus copy = new GameStatus();
        //需要把里面的数据全部拷贝一份  游戏环境 ：pacman、食物、幽灵、墙
        copy.pacMan = new PacMan(new Coordinate(newPacmanCoordinate.x, newPacmanCoordinate.y));
        copy.ghost = new Ghost(new Coordinate(origin.ghost.coordinate.x, origin.ghost.coordinate.y));

        //需要把食物复制一份
        boolean[][] originFoods = origin.foods;
        //二维数组，表示的是首先它是一个数组，其实数组里面的每个元素不是之前的整数等，而是又是一个数组
        copy.foods = new boolean[originFoods.length][originFoods[0].length];

        for (int x = 0; x < originFoods.length; x++) {
            for (int y = 0; y < originFoods[x].length; y++) {
                //给数组中的每一个元素进行赋值操作 true false
                copy.foods[x][y] = originFoods[x][y];
            }
        }
        //还有可能是食物被pacman正好吃了
        //这个地方可以直接放心大胆地去给它设置成false，如果原来这个位置不是食物，那么它就是false；如果是食物，此时也被吃掉了，所以变成了false
        copy.foods[newPacmanCoordinate.x][newPacmanCoordinate.y] = false;

        //墙永远不会变，永远不会修改
        boolean[][] walls = origin.walls;

        copy.walls = origin.walls;

        return copy;
    }

    public static GameStatus cloneGhostStatus(Coordinate newGhostCoordinate, GameStatus origin) {
        GameStatus copy = new GameStatus();
//        游戏环境 ：pacman、食物、幽灵、墙
        copy.ghost = new Ghost(new Coordinate(newGhostCoordinate.x, newGhostCoordinate.y));
        copy.pacMan = new PacMan(new Coordinate(origin.pacMan.coordinate.x, origin.pacMan.coordinate.y));

        //食物
        boolean[][] originFoods = origin.foods;
        //二维数组，表示的是首先它是一个数组，其实数组里面的每个元素不是之前的整数等，而是又是一个数组
        copy.foods = new boolean[originFoods.length][originFoods[0].length];

        for (int x = 0; x < originFoods.length; x++) {
            for (int y = 0; y < originFoods[x].length; y++) {
                //给数组中的每一个元素进行赋值操作 true false
                copy.foods[x][y] = originFoods[x][y];
            }
        }

        //墙永远不会变，永远不会修改
        boolean[][] walls = origin.walls;
        copy.walls = origin.walls;

        return copy;
    }
}
