package com.cskaoyan.pacman.model;

import com.cskaoyan.pacman.draw.Position;

/**
 * @ClassName Node
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/21 10:41
 * @Version V1.0
 **/
public class Node {

    public Coordinate coordinate;

    //上一个节点
    public Node preNode;

    //从上一个节点是如何过来的
    public Position position;


    //目前已经的花费
    public int preCost;

    //总花费 = 当前的花费 + 预估的花费
    public double totalCost;


    public Node(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Node(Coordinate coordinate, Node preNode, Position position) {
        this.coordinate = coordinate;
        this.preNode = preNode;
        this.position = position;
    }

    public Node(Coordinate coordinate, Node preNode, Position position, int preCost, double totalCost) {
        this.coordinate = coordinate;
        this.preNode = preNode;
        this.position = position;
        this.preCost = preCost;
        this.totalCost = totalCost;
    }
}
