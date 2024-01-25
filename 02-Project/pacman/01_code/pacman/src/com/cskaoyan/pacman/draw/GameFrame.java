package com.cskaoyan.pacman.draw;

import com.cskaoyan.pacman.config.GameParameter;
import com.cskaoyan.pacman.status.GameStatus;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName GameFrame
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 11:54
 * @Version V1.0
 **/
public class GameFrame extends JFrame {

    public int x;

    public int y;

    public int ratio;

    public GamePanel gamePanel;

    public GameFrame(GameStatus gameStatus) {
        this.x = gameStatus.xNum;
        this.y = gameStatus.yNum;

        //缩放/扩放比率
        this.ratio = GameParameter.ratio;
        //设置标题的名称
        setTitle("PacMan");
        //设置默认的关闭方式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体的大小
        setSize(x * ratio + 45, y * ratio + 90);
        //窗体居中
        setLocationRelativeTo(null);
        //设置窗体最小大小
        setMinimumSize(getSize());
        //是否显示窗体
        setVisible(true);


        //设置一个面板，用来实际的显示
        setLayout(new GridBagLayout());
        gamePanel = new GamePanel(gameStatus);
        gamePanel.setPreferredSize(new Dimension(x * ratio, y * ratio));
        add(gamePanel, new GridBagConstraints());

        //添加窗体监听鼠标/键盘事件
        //addKeyListener(gamePanel);
    }

    public void close() {
        dispose();
    }
}
