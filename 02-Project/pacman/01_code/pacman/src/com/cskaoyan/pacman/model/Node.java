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

    public Node preNode;

    public Position position;


    public Node(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Node(Coordinate coordinate, Node preNode, Position position) {
        this.coordinate = coordinate;
        this.preNode = preNode;
        this.position = position;
    }
}
