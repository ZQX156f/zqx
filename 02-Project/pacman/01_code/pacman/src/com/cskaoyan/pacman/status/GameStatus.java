package com.cskaoyan.pacman.status;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Ghost;
import com.cskaoyan.pacman.model.PacMan;
import com.cskaoyan.pacman.util.Constant;
import com.cskaoyan.pacman.util.MapLoader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName GameStatus
 * @Description: TODO 游戏内此时的状态
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 11:22
 * @Version V1.0
 **/
public class GameStatus {

    public int xNum;

    // y轴高度 左下角为坐标原点
    public int yNum;

    // 地图的文本信息
    public Character[][] gameMap;

    //墙的位置
    public boolean[][] walls;

    //食物位置
    public boolean[][] foods;

    //食物总数
    public int totalFoods;

    //剩余的食物数量
    public int availableFoods;


    //幽灵列表
    public Ghost ghost;

    //pacman信息
    public PacMan pacMan;

    //在游戏状态对象中去进一步初始化地图、pacman、幽灵、食物等
    public GameStatus(String gameMap) {
        //读取加载地图信息
        List<String> mapData = MapLoader.load(gameMap);

        //初始化地图
        initMap(mapData);

    }

    private void initMap(List<String> mapData) {
        yNum = mapData.size();
        xNum = mapData.get(0).length();

        gameMap = new Character[xNum][yNum];
        walls = new boolean[xNum][yNum];
        foods = new boolean[xNum][yNum];

        //遍历地图的每一行 y轴
        for (int i = 0; i < yNum; i++) {
            String line = mapData.get(i);
            //遍历每一行的每个字符信息 x轴
            for (int j = 0; j < line.length(); j++) {
                //遍历每一行中的每个字符，也就是渲染每一行的墙、食物、幽灵、pacman信息
                char c = line.charAt(j);
                //坐标原点转换
                gameMap[j][yNum - 1 - i] = c;

                if(c == Constant.WALL){
                    walls[j][yNum - 1 - i] = true;
                }else if(c == Constant.FOODS){
                    foods[j][yNum - 1 - i] = true;
                    totalFoods ++;
                }else if(c == Constant.PACMAN){
                    pacMan = new PacMan(new Coordinate(j, yNum - 1 - i));
                }else if(c == Constant.GHOST){
                    ghost = new Ghost(new Coordinate(j, yNum - 1 - i));
                }
            }
        }
        availableFoods = totalFoods;
    }

    public int getxNum() {
        return xNum;
    }

    public void setxNum(int xNum) {
        this.xNum = xNum;
    }

    public int getyNum() {
        return yNum;
    }

    public void setyNum(int yNum) {
        this.yNum = yNum;
    }

    public Character[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(Character[][] gameMap) {
        this.gameMap = gameMap;
    }

    public boolean[][] getWalls() {
        return walls;
    }

    public void setWalls(boolean[][] walls) {
        this.walls = walls;
    }

    public boolean[][] getFoods() {
        return foods;
    }

    public void setFoods(boolean[][] foods) {
        this.foods = foods;
    }

    public int getTotalFoods() {
        return totalFoods;
    }

    public void setTotalFoods(int totalFoods) {
        this.totalFoods = totalFoods;
    }

    public int getAvailableFoods() {
        return availableFoods;
    }

    public void setAvailableFoods(int availableFoods) {
        this.availableFoods = availableFoods;
    }

    public Ghost getGhost() {
        return ghost;
    }

    public void setGhost(Ghost ghost) {
        this.ghost = ghost;
    }

    public PacMan getPacMan() {
        return pacMan;
    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public void ghostMove() {
        //如果幽灵的行进路线、计划是空，则去获取一个行进计划
        if(ghost.routerPlan == null || ghost.routerPlan.isEmpty()){
                ghost.setPlan(this);
        }
        //幽灵按照行进计划去移动
        ghost.move();
    }

    public void pacmanMove() {
        if(pacMan.routerPlan == null || pacMan.routerPlan.isEmpty()){
            pacMan.setPlan(this);
        }
        pacMan.move();
    }
}
