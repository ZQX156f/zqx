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


    //虽然在此处，我们使用的是接口的引用来接收，那么可不可以在初始化的时候，我们传递过来一个该Agent接口的实现类，用Agent来接受？是不是就是接口指向子类实现
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
        //行进计划是空的，则需要去获取一个行进计划
        if(routerPlan == null || routerPlan.isEmpty()){
            //重点关注这一行代码
            //但是大家关注agent的类型，发现是一个接口，那么可以直接调用接口吗？不可以
            //这行代码怎么运行的呢？ 面向对象的特征还记得吗？封装、继承、多态
            //可不可以使用接口指向子类实现的方式
            routerPlan = agent.getPlan(gameStatus);
        }
        //后面的代码实际上是去画行进路线用到的
        //下面这段代码实际上便是用来去画游戏中的绿色的行进路线的
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
