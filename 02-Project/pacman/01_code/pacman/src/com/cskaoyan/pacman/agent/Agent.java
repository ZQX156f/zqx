package com.cskaoyan.pacman.agent;

import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.status.GameStatus;

import java.util.Queue;

/**
 * @ClassName Agent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 11:32
 * @Version V1.0
 **/
public interface Agent {

    //返回的便是一个Position的队列；最终返回的便是一个方位的集合
    Queue<Position> getPlan(GameStatus gameStatus);
}
