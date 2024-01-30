package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
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
 * @ClassName EscapeGhostPacManAgent
 * @Description: TODO
 * pacman此时需要做的事情是找到食物，吃掉
 * 还需要躲避幽灵，不让幽灵吃掉自己
 * 此时pacman需要时刻感知幽灵的位置----pacman也采取每次只行进一步的方式
 * 如何去感知有没有危险？
 * 将幽灵的现在坐标和周围的上下左右坐标全部都设置为危险坐标，如果在pacman到食物的这一条路线上发现了危险坐标，那么如果非常接近，那么应该抓紧远离；这个时候其实非常具有主观性，多少步算接近呢？
 * 找到食物之后，规划出一条路线来，需要去看一下：规划路线上的坐标有没有在危险坐标中的，如果没有，可以先走着
 * 如果有，看一下距离当前pacman的距离，如果比较远，也是先走着看；如果比较近了，那么赶紧跑
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 15:14
 * @Version V1.0
 **/
public class EscapeGhostPacManAgent implements Agent {

    FoodStrategy foodStrategy = new DoubleCircularFoodStrategy();

    MathDistance distance = new ManhattanDistance();

    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        Queue<Position> positions = new LinkedList<>();

        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;

        Coordinate foodCoordinate = foodStrategy.getFoodCoordinate(gameStatus);

        Node initNode = new Node(pacmanCoordinate, null, null, 0, distance.getDistance(pacmanCoordinate, foodCoordinate));

        TreeSet<Node> treeSet = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.totalCost - o2.totalCost > 0){
                    return 1;
                }
                return -1;
            }
        });

        treeSet.add(initNode);

        Set<Coordinate> searchedCoordinates = new HashSet<>();


        while (! treeSet.isEmpty()){
            //如果不为空，循环往复地去取出最小花费的节点，取出周围的临近节点，计算花费，再次放入到treeset中.....
            Node smallestNode = treeSet.pollFirst();

            if(smallestNode.coordinate.equals(foodCoordinate)){
                positions = Calculation.getPositions(smallestNode);
                //先设置危险坐标
                List<Coordinate> dangerousCoordinates = new ArrayList<>();
                //把幽灵当前的坐标以及上下左右的坐标全部置为危险坐标
                dangerousCoordinates.add(gameStatus.ghost.coordinate);
                dangerousCoordinates.add(Calculation.getCoordinate(gameStatus.ghost.coordinate, Position.UP));
                dangerousCoordinates.add(Calculation.getCoordinate(gameStatus.ghost.coordinate, Position.DOWN));
                dangerousCoordinates.add(Calculation.getCoordinate(gameStatus.ghost.coordinate, Position.LEFT));
                dangerousCoordinates.add(Calculation.getCoordinate(gameStatus.ghost.coordinate, Position.RIGHT));

                //食物
                //需要找到pacman到食物规划的这一条路线
                //行进路线中是否有幽灵
                boolean hasGhost = false;
                int steps = 0;
                List<Coordinate> routeCoordinates = Calculation.getRouteCoordinates(smallestNode);
                for (int i = 0; i < routeCoordinates.size(); i++) {
                    steps ++;
                    Coordinate c = routeCoordinates.get(i);
                    if(dangerousCoordinates.contains(c)){
                        //行进路线中的某个坐标在危险坐标之中
                        hasGhost = true;
                        break;
                    }
                }
                //看一下当前的行进路线中是否有幽灵
                if(! hasGhost){
                    //先走着
                    Position poll = positions.poll();
                    positions.clear();
                    positions.offer(poll);
                }else {
                    //行进路线中有幽灵
                    //假设：我们设定的规则是5步开外，先走着；4步开外，先stop停住；4步以内，赶紧跑
                    if(steps > 5){
                        Position poll = positions.poll();
                        positions.clear();
                        positions.offer(poll);
                    }else if(steps == 5){
                        positions.clear();
                        positions.offer(Position.STOP);
                    }else {
                        //赶紧跑 找临近节点，临近节点要求不在危险坐标中，然后选择一个方向跑
                        //当前list用来去存那些不在危险坐标中的节点，也就是可以行进的节点
                        List<Node> availableNodes = new ArrayList<>();
                        List<Node> nodes = Calculation.getAroundNodes(new Node(gameStatus.pacMan.coordinate), gameStatus);
                        for (Node node : nodes) {
                            //不在危险坐标中的节点
                            if(!dangerousCoordinates.contains(node.coordinate)){
                                availableNodes.add(node);
                            }
                        }
                        for (Node availableNode : availableNodes) {
                            System.out.println(availableNode.coordinate);
                        }
                        //使用随机的方法来获取availableNodes的节点方向；当前也可以固定每次取index=0
                        // [0,1)数字
                        int index = (int) (Math.random() * availableNodes.size());
                        if(index == 0 && availableNodes.size() == 0){
                            //幽灵把pacman给逼到了墙角，先STOP，先看看
                            positions.clear();
                            positions.offer(Position.STOP);
                        }else {
                            positions.clear();
                            positions.offer(availableNodes.get(index).position);
                        }
                    }
                }
                return positions;
            }


            List<Node> aroundNodes = Calculation.getAroundNodes(smallestNode, gameStatus);
            for (Node adNode : aroundNodes) {
                //这部分代码还是需要加上，否则会进入A找B，B找A陷入死循环中
                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                treeSet.add(new Node(adNode.coordinate, adNode.preNode, adNode.position, smallestNode.preCost + 1, smallestNode.preCost + 1 + distance.getDistance(adNode.coordinate, foodCoordinate)));
            }
        }


        return positions;
    }
}
