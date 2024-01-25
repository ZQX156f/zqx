package com.cskaoyan.pacman.agent;

import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.status.GameStatus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName EscapeGhostPacManAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 15:14
 * @Version V1.0
 **/
public class EscapeGhostPacManAgent implements Agent{
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();
        positions.offer(Position.LEFT);
        positions.offer(Position.LEFT);
        positions.offer(Position.LEFT);
        positions.offer(Position.LEFT);
        positions.offer(Position.UP);
        positions.offer(Position.UP);
        positions.offer(Position.UP);
        positions.offer(Position.UP);
        positions.offer(Position.LEFT);
        positions.offer(Position.LEFT);
        positions.offer(Position.DOWN);
        positions.offer(Position.DOWN);
        positions.offer(Position.DOWN);
        positions.offer(Position.DOWN);

        return positions;
    }
}
