package com.cskaoyan.pacman.food;

import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.util.*;

/**
 * @ClassName BFSFoodStrategy
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/30 20:06
 * @Version V1.0
 **/
public class BFSFoodStrategy implements FoodStrategy {
    @Override
    public Coordinate getFoodCoordinate(GameStatus gameStatus) {
        //pacman使用BFS策略来查找周围的食物
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        boolean[][] foods = gameStatus.foods;

        LinkedList<Node> queue = new LinkedList<>();


        queue.addFirst(new Node(pacmanCoordinate,null, null));
        Set<Coordinate> searchedCoordinates = new HashSet<>();
        searchedCoordinates.add(pacmanCoordinate);
        while (! queue.isEmpty()){
            Node node = queue.pollLast();

            if(foods[node.coordinate.x][node.coordinate.y]){
                //食物
                return node.coordinate;
            }


            List<Node> aroundNodes = Calculation.getAroundNodes(node, gameStatus);

            for (Node adNode : aroundNodes) {
                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                queue.addFirst(adNode);
            }
        }
        return null;
    }
}
