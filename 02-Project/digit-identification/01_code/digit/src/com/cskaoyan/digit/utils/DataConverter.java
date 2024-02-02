package com.cskaoyan.digit.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DataConverter
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/2/2 11:40
 * @Version V1.0
 **/
public class DataConverter {

    private static Map<Character, Integer> encodeMap = new HashMap<>();

    static {
        encodeMap.put(' ', 0);
        encodeMap.put('+', 1);
        encodeMap.put('#', 2);
    }

    public static int convert(char pixel) {
        //根据传递进来的空字符串 # + 转换成数字012
        return encodeMap.get(pixel);
    }
}
