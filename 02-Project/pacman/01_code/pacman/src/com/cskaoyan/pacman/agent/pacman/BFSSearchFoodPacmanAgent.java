package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.util.*;

/**
 * @ClassName BFSSearchFoodPacmanAgent
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 9:40
 * @Version V1.0
 **/
public class BFSSearchFoodPacmanAgent implements Agent {
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();
        //找到一个未知的顶点(以pacman的位置作为起始点)，从该顶点出发遍历所有的子节点，处理完所有的子节点之后，依次再去处理这些子节点临近的周围的子节点
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        Node initNode = new Node(pacmanCoordinate);
        boolean[][] foods = gameStatus.foods;

        //需要用一个容器来存储这些节点
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(initNode);

        Set<Coordinate> searchedCoordinates = new HashSet<>();

        //循环遍历所有的子节点，直至最后是食物的坐标位置
        while (! queue.isEmpty()){
            Node node = queue.pollLast();

            gameStatus.pacMan.pacmanTraversedNodes.add(node.coordinate);
            //查找该节点周围的所有的临近子节点信息
            //结束的标志：是否是食物
            if(foods[node.coordinate.x][node.coordinate.y]){
                //是食物-----> 根据preNode便可以反向找到pacman，找到pacman之后，所有的行进方向也就可以拿到了
                positions = Calculation.getPositions(node);
                return positions;
            }


            List<Node> aroundNodes = Calculation.getAroundNodes(node, gameStatus);
            for (Node adNode : aroundNodes) {
                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                //会不会走回环路
                queue.addFirst(adNode);
            }
        }

        return positions;
    }
}
