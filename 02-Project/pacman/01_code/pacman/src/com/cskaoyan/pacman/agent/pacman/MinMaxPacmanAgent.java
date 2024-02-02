package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.model.ScorePosition;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;
import com.cskaoyan.pacman.util.GameStatusUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MinMaxPacmanAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/31 10:53
 * @Version V1.0
 **/
public class MinMaxPacmanAgent implements Agent {
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();
        //不仅要返回分数，还要返回最大的分数对应的方向，所以我们返回一个对象
        //最终希望max返回的结果便是对应的方向和最大的分数，直接取出方向即可
         ScorePosition scorePosition = max(3, gameStatus);
         positions.offer(scorePosition.position);
        return positions;
    }

    //depth层级，就是表示的是思考接下来的几步操作；视野的宽度
    public ScorePosition max(int depth, GameStatus gameStatus) {
        if(depth < 1){
            //结束了 todo
            return new ScorePosition(0, Position.STOP);
        }

        //depth层级--  需要在pacman回合--，幽灵回合不需要减
        depth --;

        //max是pacman所在的一方，首先先获取pacman的位置
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        //推演-----pacman根据当前所在的位置，可以行进的方向、节点
        List<Node> aroundNodes = Calculation.getAroundNodes(new Node(pacmanCoordinate), gameStatus);
        //设定一个初始的值，如果在推演接下来的操作的时候，如果得到了一个比较大的值，那么存储在这个对象中
        ScorePosition initState = new ScorePosition(-1000000, Position.STOP);
        for (Node item : aroundNodes) {
            //每一个item其实就是我们图中所画出来的max中的一个图选择的方向
            int stepScore = -1;
            //如果pacman和食物相遇了，那么当前得分先加50分
            if(gameStatus.foods[item.coordinate.x][item.coordinate.y]){
                stepScore += 50;
                stepScore += depth;
            }
            //还需要判断pacman走的这一步会不会和幽灵相遇
            if(item.coordinate.equals(gameStatus.ghost.coordinate)){
                stepScore += -1000000;
            }

            //随后就可以去推演幽灵可以如何应对了？
            //但是如果此时，我传递gameStatus有没有问题？有问题
            //比如gameStatus里面的pacman的位置此时是在起始位置的，但是我们现在推演的时候，其实已经让它移动了一个位置，甚至有可能它移动了一个位置之后，已经吃掉了一个食物，所以不可以直接用原来的gameStatus
            //那能不能对原来的gameStatus做修改呢？也不可以，因为我现在只是在心中做推演，我还没有真正的去走，这个时候你不可以去修改gameStatus里面的数据状态
            //接下来需要做的事情就是根据当前节点的信息，复制当前的游戏状态
            GameStatus gameStatusCopy = GameStatusUtils.clonePacmanStatus(item.coordinate, gameStatus);
            int min = min(depth, gameStatusCopy).score;
            stepScore += min;
            if(stepScore > initState.score){
                //把较大的值赋值给对象
                initState.score = stepScore;
                //推演的其中一个节点对应的方向
                initState.position = item.position;
            }

        }

        return initState;
    }

    public ScorePosition min(int depth, GameStatus gameStatus) {
        //在pacman的策略中，min其实指的便是幽灵
        Coordinate ghostCoordinate = gameStatus.ghost.coordinate;

        //获取幽灵周围可以行进的节点
        ScorePosition initState = new ScorePosition(1000000, Position.STOP);
        List<Node> aroundNodes = Calculation.getAroundNodes(new Node(ghostCoordinate), gameStatus);
        for (Node item : aroundNodes) {
            //幽灵可以行进的方向，也是在进行推演
            int stepScore = -1;
            //只需要考虑是否和pacman相遇
            //注意：pacman和幽灵公用的是一个分数，pacman想让分数增加；幽灵希望分数减少
            if(item.coordinate.equals(gameStatus.pacMan.coordinate)){
                stepScore += -1000000;
            }
            //随后调用max操作，但是在调用max操作之前需要先克隆一份游戏的状态
            GameStatus gameStatusCopy = GameStatusUtils.cloneGhostStatus(item.coordinate, gameStatus);
            int max = max(depth, gameStatusCopy).score;
            stepScore += max;
            //需要找到一个小值
            if(stepScore < initState.score){
                initState.score = stepScore;
                initState.position = item.position;
            }
        }
        return initState;
    }
}
