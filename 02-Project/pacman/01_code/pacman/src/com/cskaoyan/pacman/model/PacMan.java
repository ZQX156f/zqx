package com.cskaoyan.pacman.model;

import com.cskaoyan.pacman.agent.Agent;
import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.draw.Position;
import com.cskaoyan.pacman.status.GameStatus;
import com.cskaoyan.pacman.util.Calculation;
import com.cskaoyan.pacman.util.ClassUtils;
import com.sun.javafx.geom.Arc2D;

import java.util.*;

/**
 * @ClassName PacMan
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 11:25
 * @Version V1.0
 **/
public class PacMan {

    //搜寻遍历的路径
    public LinkedHashSet<Coordinate> pacmanTraversedNodes = new LinkedHashSet<>();

    public Coordinate coordinate;

    //从pacman到目标位置的方向集合,也就是pacman的行进路线
    public Queue<Position> routerPlan;

    public Node routerPaint;


    private Agent agent;

    public PacMan(Coordinate coordinate) {
        this.coordinate = coordinate;

        Class<? extends Agent> aClass = Agent.class;

        try {
            //查询的到当前项目中的所有Class对象
            List<Class> classList = ClassUtils.getAllClasses();
            String ghostAgent = GameParameter.pacmanAgent;
            for (Class cl : classList) {
                //如果遍历出来的类是Agent的子类对象，并且类的名称中包含配置的名称，则是我们需要的
                if(aClass.isAssignableFrom(cl)){
                    if(cl.getSimpleName().toLowerCase().contains(ghostAgent.toLowerCase())){
                        this.agent = (Agent) cl.newInstance();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPlan(GameStatus gameStatus) {
        if(routerPlan == null || routerPlan.isEmpty()){
            routerPlan = agent.getPlan(gameStatus);
        }
        Position[] positions = routerPlan.toArray(new Position[]{});
        routerPaint = new Node(coordinate);
        for (int i = 0; i < positions.length; i++) {
            Coordinate coord = Calculation.getCoordinate(routerPaint.coordinate, positions[i]);
            routerPaint = new Node(coord, routerPaint, positions[i]);
        }
    }

    public void move() {
        if(routerPlan != null && !routerPlan.isEmpty()){
            Position poll = routerPlan.poll();
            coordinate = Calculation.getCoordinate(coordinate, poll);
        }
    }
}
