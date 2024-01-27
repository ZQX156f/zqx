package com.cskaoyan.pacman.agent.pacman;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;

import java.util.*;

/**
 * @ClassName DFSSearchFoodPacmanAgent
 * @Description: TODO
 * 深度优先遍历主要的思路是从图中的一个未访问的顶点出发，沿着一条路一直走到底，然后从这条路的尽头再回退到上一个节点，再从另外一条路走到底。不断递归重复该过程，直至所有的点全都遍历完成。
 * 思路：
 * 1.选择pacman的起始位置来当做顶点
 * 2.找到pacman所在位置处可以行进的所有的方向，其周围可以行进的方向可以看做是其子节点
 * 3.拿到所有节点之后，一个一个节点进行尝试，尝试其能否走得通
 * 4.深度优先是取出一个点之后，一直处理这个点的后续所有情况
 *
 * 取出其中的一个子节点，再次去查找其所有的临近子节点信息............
 * 最终出口：node节点里面包含了坐标，结束的标志是什么？找到了食物的那个节点
 * 如何知道其是食物的节点呢？判断最终备选项的坐标和食物的坐标是否一致----就是我们需要的
 * 找到食物的node之后，根据prenode顺着网线就找到了pacman
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/27 9:55
 * @Version V1.0
 **/
public class DFSSearchFoodPacmanAgent implements Agent {
    @Override
    public Queue<Position> getPlan(GameStatus gameStatus) {
        //注意到代码中存在一个node类，里面包含坐标、preNode、方向
        //prenode很关键，只要找到了事务的这个node节点，那么利用preNode就完全可以顺着这条路找回pacman
        //找到pacman之后，node中刚好有一个方向，将所有的方向添加到一个集合中，最终便是pacman到食物的所有的方向的集合
        //首先将pacman的坐标包装成一个node节点
        boolean[][] foods = gameStatus.foods;
        Coordinate pacmanCoordinate = gameStatus.pacMan.coordinate;
        Node initNode = new Node(pacmanCoordinate);
        //实现深度优先思想，使用一种什么数据结构比较合适？ stack 深度优先要满足：先入后出  后入先出
        LinkedList<Node> stack = new LinkedList<>();
        //往头部添加
        stack.push(initNode);

        Set<Coordinate> searchedCoordinates = new HashSet<>();
        searchedCoordinates.add(pacmanCoordinate);

        while (! stack.isEmpty()){
            //里面的逻辑便是根据传递进来的初始节点，去寻找其临近的所有子节点，入栈
            Node polled = stack.poll();

            gameStatus.pacMan.pacmanTraversedNodes.add(polled.coordinate);

            if(foods[polled.coordinate.x][polled.coordinate.y]){
                //找到了食物
//                System.out.println(polled.coordinate);
                //最终我们需要提供的是从pacman到食物的方向的集合
                Queue<Position> positions = Calculation.getPositions(polled);

                return positions;
            }


            List<Node> aroundNodes = Calculation.getAroundNodes(polled, gameStatus);
            for (Node adNode : aroundNodes) {
                //找临近节点的时候，需要考虑的是当前遍历出来的节点是否已经处理过了
                if(searchedCoordinates.contains(adNode.coordinate)){
                    continue;
                }else {
                    searchedCoordinates.add(adNode.coordinate);
                }
                stack.push(adNode);
            }
            //取出其中的一个子节点，再次去查找其所有的临近子节点信息............
            //最终出口：node节点里面包含了坐标，结束的标志是什么？找到了食物的那个节点
            //如何知道其是食物的节点呢？判断最终备选项的坐标和食物的坐标是否一致----就是我们需要的
            //找到食物的node之后，根据prenode顺着网线就找到了pacman
        }

        return null;
    }
}
