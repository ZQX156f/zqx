package com.cskaoyan.pacman.agent.ghost;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.distance.ManhattanDistance;
import com.cskaoyan.pacman.distance.MathDistance;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.util.*;

/**
 * @ClassName ChasePacmanByAStarGhostAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 14:33
 * @Version V1.0
 **/
public class ChasePacmanByAStarGhostAgent implements Agent {

    MathDistance distance = new ManhattanDistance();

    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();
        //使用A*算法需要知道起始位置以及最终的目标位置
        Coordinate ghostCoordinate = gameStatus.ghost.coordinate;

        //目标位置
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        //构造一个node节点
        //preCost：目前的已经花费，已经行进的步骤
        //totalCost:目前已经花费 + 剩余的预估花费----> 测量距离 曼哈顿距离 欧几里得距离
        Node initNode = new Node(ghostCoordinate, null, null, 0, distance.getDistance(ghostCoordinate, pacmanCoordinate));
        //接下来，我们需要做的事情便是将起始node节点放入treeset中，后续取出该节点，找出该节点周围的所有临近节点信息，计算其总花费，再次将这些临近节点放入treeset中，后续再次取出最小花费的节点.....循环往复，直至最终便可以规划出一条路线来
        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.totalCost - o2.totalCost > 0){
                    return 1;
                }
                return -1;
            }
        });
        //把起始节点放入treeset中
        treeSet.add(initNode);

        Set<Coordinate> searchedCoordinates = new HashSet<>();

        while (! treeSet.isEmpty()){
            //因为根据comparator提供的规则，数据是应该从小到大进行排序的，所以最前面的是最小的
            Node smallestNode = treeSet.pollFirst();

            //判断是否是pacman
            if(smallestNode.coordinate.equals(pacmanCoordinate)){
                //找到pacman了 TODO
                //此时我们的代码面临一个问题，那就是幽灵大概率抓不到pacman
                //原因在于：此时是规划了一条完整的距离pacman起始位置的路径，只要行进计划不为空，不会再次去发起当前方法的再次调用
                //但是等幽灵到达pacman位置之后，pacman早已经离开了
                //解决办法：幽灵每次只行进一步
                positions = Calculation.getPositions(smallestNode);
                Position polled = positions.poll();
                //清空
                positions.clear();
                positions.offer(polled);
                return positions;
            }

            //如果不是pacman，那么我们需要去再次查找其周围的临近节点，计算出总花费
            List<Node> aroundNodes = Calculation.getAroundNodes(smallestNode, gameStatus);
            for (Node adNode : aroundNodes) {
                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                //preCost:前一个节点的花费 + 1；前一个节点：smallestNode、adNode.preNode
                //totalCost：当前的花费 + 预估的剩余花费
                treeSet.add(new Node(adNode.coordinate, adNode.preNode, adNode.position, smallestNode.preCost + 1, smallestNode.preCost + 1 + distance.getDistance(adNode.coordinate, pacmanCoordinate)));
            }
        }


        return positions;
    }
}
