package com.cskaoyan.pacman.agent.ghost;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.status.GameStatus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ChasePacmanByAStarGhostAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 14:33
 * @Version V1.0
 **/
public class ChasePacmanByAStarGhostAgent implements Agent {
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();
        positions.offer(Position.STOP);

        return positions;
    }
}
