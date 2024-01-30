package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.distance.EuclideanDistance;
import com.cskaoyan.pacman.distance.ManhattanDistance;
import com.cskaoyan.pacman.distance.MathDistance;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.food.DoubleCircularFoodStrategy;
import com.cskaoyan.pacman.food.FoodStrategy;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.util.*;

/**
 * @ClassName AStarSearchFoodPacmanAgent
 * @Description: TODO
 * A*启发式搜索：里面有一个非常重要的概念，叫做评估函数，用来去评估每个节点的重要性，我们这里面使用的是花费来当做评估的指标，花费如何理解呢？花费在寻址过程中，我们可以理解为总步数、总路径
 * 花费 = 已经花费 + 后面的预估花费
 * 步数 = 目前已经行进的距离(步数) + 后面预估还有的步数（大家不要去较真，如果我们计算得到的是三角形的第三边，你不用说去得到真实的行进步数，只需要用的到的预估步数来代替即可）
 * 总的步数要求尽可能小
 * 启发式搜索：需要有一个起始位置，还有一个目标位置；需要有一个最终的方向 食物的坐标
 * 所以，我们需要先获取食物的坐标
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/29 10:17
 * @Version V1.0
 **/
public class AStarSearchFoodPacmanAgent implements Agent {

    //如果今后，你希望使用深度或者广度来去实现查找食物坐标，只需要变更接口的指向即可
    FoodStrategy foodStrategy = new DoubleCircularFoodStrategy();

    MathDistance distance = new ManhattanDistance();

    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();

        //启发式搜索需要有两个坐标，一个是起始的pacman位置；一个是最终的食物坐标位置
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        //获取食物的坐标位置，如何获取呢？1.采用深度优先算法去找食物 2.采用广度优先算法来找食物 3.双重for循环确定某个坐标位置是否是食物
        //注意：这里面我们使用深度和广度来寻找食物，既然已经寻找到了食物的坐标，这么这条路线不是已经确定了吗？但是实际上无论是深度还是广度，规划出来的路径始终是不尽如人意的，大概率不是一条最优路径；希望使用A*启发式搜索可以规划出一条最优路径来

        //直接取编写获取食物的代码吗？还是去做一些封装处理，然后调用？
//        Coordinate foodCoordinate = FoodUtils.getFoodCoordinateByDoubleCircu(gameStatus);
        Coordinate foodCoordinate = foodStrategy.getFoodCoordinate(gameStatus);

        //总花费 = 0 + pacman到食物的预估的花费；需要有一个评价的指标：曼哈顿距离  欧几里得距离
        Node initNode = new Node(pacmanCoordinate, null, null, 0, distance.getDistance(pacmanCoordinate, foodCoordinate));

        Set<Coordinate> searchedCoordinates = new HashSet<>();

        //把节点放入到容器中，从容器中取得时候，每次都是去取总花费最小的节点出来
        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                double v = o1.totalCost - o2.totalCost;
                if(v > 0){
                    return 1;
                }
                return -1;
            }
        });
        treeSet.add(initNode);

        while (! treeSet.isEmpty()){
            //取出花费最小的节点
            Node smallestNode = treeSet.pollFirst();

            gameStatus.pacMan.pacmanTraversedNodes.add(smallestNode.coordinate);

            //最终需要判断该节点是否是食物节点
            if(smallestNode.coordinate.equals(foodCoordinate)){
                //找到食物
                return Calculation.getPositions(smallestNode);
            }


            //再次使用相同的方法去查找其临近的周围节点
            List<Node> aroundNodes = Calculation.getAroundNodes(smallestNode, gameStatus);
            for (Node adNode : aroundNodes) {

                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                //需要将周围的临近节点的花费计算好，也放入到treeset中，会进行排序
                treeSet.add(new Node(adNode.coordinate, adNode.preNode, adNode.position, smallestNode.preCost + 1, smallestNode.preCost + 1 + distance.getDistance(adNode.coordinate, foodCoordinate)));
            }
        }

        return positions;
    }
}
