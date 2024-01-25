package com.cskaoyan.pacman.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName GameParameter
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 11:32
 * @Version V1.0
 **/
public class GameParameter {

    private static Map<String, String> map ;

    public static String gameMap;
    public static String pacmanAgent;
    public static String ghostAgent;
    public static int timedRedraw;
    public static int ratio;
    public static int foodRatio;
    public static int bgColor;
    public static int wallColor;
    public static int foodColor;
    public static int pacmanColor;
    public static int pacmanEyesColor;
    public static boolean visiblePath;
    public static int pathColor;
    public static int searchedModuleColor;


    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 把properties加载的配置上配置的信息:
        //   复制一份到HashMap中
        map = (HashMap<String, String>) new HashMap(properties);

        // 再从map中获取一个个参数, 赋值给全局变量
        // (如果需要类型转化, 转为合适的类型)
        gameMap = map.get("gameMap");
        pacmanAgent = map.get("pacmanAgent");
        ghostAgent = map.get("ghostAgent");
        timedRedraw = Integer.parseInt(map.get("timedRedraw"));
        ratio = Integer.parseInt(map.get("ratio"));
        foodRatio = Integer.parseInt(map.get("foodRatio"));
        bgColor =  Integer.parseInt(map.get("bgColor") , 16);
        wallColor = Integer.parseInt( map.get("wallColor"), 16);
        foodColor = Integer.parseInt(map.get("foodColor"), 16);
        pacmanColor = Integer.parseInt(map.get("pacmanColor"), 16);
        pacmanEyesColor = Integer.parseInt(map.get("pacmanEyesColor"), 16);
        visiblePath =  Boolean.parseBoolean(map.get("visiblePath"));
        pathColor = Integer.parseInt(map.get("pathColor"), 16);
        searchedModuleColor = Integer.parseInt(map.get("searchedModuleColor"), 16);
    }

}
