package com.cskaoyan.pacman.util;


import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.model.Coordinate;
import com.cskaoyan.pacman.model.Node;
import com.cskaoyan.pacman.status.GameStatus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Calculation
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/10/10 17:49
 * @Version V1.0
 **/
public class Calculation {
    public static Coordinate getCoordinate(Coordinate coordinate, Position direction) {
        int x = coordinate.x;
        int y = coordinate.y;
        Coordinate nextCoordinate = null;
        switch (direction){
            case LEFT:
                nextCoordinate = new Coordinate(x - 1, y);
                break;
            case RIGHT:
                nextCoordinate = new Coordinate(x + 1, y);
                break;
            case UP:
                nextCoordinate = new Coordinate(x, y + 1);
                break;
            case DOWN:
                nextCoordinate = new Coordinate(x, y - 1);
                break;
            case STOP:
                nextCoordinate = new Coordinate(x, y);
                break;
            default:
        }
        return nextCoordinate;
    }

    /**
     * 寻找传递进来的当前节点周围的非墙节点信息
     *
     * @param node
     * @param gameStatus
     * @return
     */
    public static List<Node> getAroundNodes(Node node, GameStatus gameStatus) {
        //墙、食物是使用二维数组来实现的，你传递进来一个x，y坐标；如果是true则是墙、食物；
        boolean[][] walls = gameStatus.walls;

        //根据传递进来的node节点的坐标，计算出其周围的上下左右的坐标，判断这些坐标是否是墙
        Coordinate upCoordinate = getCoordinate(node.coordinate, Position.UP);
        Coordinate downCoordinate = getCoordinate(node.coordinate, Position.DOWN);
        Coordinate leftCoordinate = getCoordinate(node.coordinate, Position.LEFT);
        Coordinate rightCoordinate = getCoordinate(node.coordinate, Position.RIGHT);

        List<Node> nodeList = new ArrayList<>();

        if(!walls[leftCoordinate.x][leftCoordinate.y]){
            //左坐标不是墙
            nodeList.add(new Node(leftCoordinate, node, Position.LEFT));
        }
        if(!walls[rightCoordinate.x][rightCoordinate.y]){
            //右坐标不是墙
            nodeList.add(new Node(rightCoordinate, node, Position.RIGHT));
        }

        if(!walls[upCoordinate.x][upCoordinate.y]){
            //上坐标不是墙
            nodeList.add(new Node(upCoordinate, node, Position.UP));
        }
        if(!walls[downCoordinate.x][downCoordinate.y]){
            //下坐标不是墙
            nodeList.add(new Node(downCoordinate, node, Position.DOWN));
        }


        return nodeList;
    }

    public static Queue<Position> getPositions(Node node) {
        //先顺着网线（preNode）将全部的node找到
        Queue<Position> positions = new LinkedList<>();
        List<Node> nodeList = getRouteNodes(node);
        for (int i = 0; i < nodeList.size(); i++) {
            positions.add(nodeList.get(i).position);
        }
        return positions;
    }

    //获取行进路线上完整的node信息的集合，但是需要注意的是：
    //返回的从pacman到食物的node节点信息，也将pacman移除了出去
    public static List<Node> getRouteNodes(Node node) {
        //因为node中存在一个preNode指向的是上一个节点，顺着preNode找到全部的节点信息
        LinkedList<Node> nodes = new LinkedList<>();
        Node temp = node;
        while (temp != null){
            //因为我始终是执行的是插在首部，所以最终的pacman是在第一个元素
            nodes.addFirst(temp);
            temp = temp.preNode;
        }
        //将pacman移除出去
        nodes.pollFirst();
        return nodes;
    }
}
