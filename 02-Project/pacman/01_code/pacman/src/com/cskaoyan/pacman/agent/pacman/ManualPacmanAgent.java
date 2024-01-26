package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.status.GameStatus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ManualPacmanAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 15:12
 * @Version V1.0
 **/
public class ManualPacmanAgent implements Agent {
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
//        Queue<Position> positions = new LinkedList<>();
//        positions.offer(Position.STOP);
        Queue<Position> typedKeys = gameStatus.typedKeys;
        if(typedKeys.isEmpty()){
            typedKeys.offer(Position.STOP);
        }
        return typedKeys;
    }
}
