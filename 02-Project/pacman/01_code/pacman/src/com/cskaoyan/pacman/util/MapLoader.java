package com.cskaoyan.pacman.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MapLoader
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2023/12/20 11:38
 * @Version V1.0
 **/
public class MapLoader {
    public static List<String> load(String gameMap) {
        List<String> list = new ArrayList<>();
        try {
            //会读取项目根目录下map目录中以.txt结尾的文件
            BufferedReader reader = new BufferedReader(new FileReader("map/" + gameMap + ".txt"));
            String line = null;
            while ((line = reader.readLine()) != null){
                list.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;

    }
}
