package com.cskaoyan.pacman.reflect;

/**
 * @ClassName Dog
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 10:22
 * @Version V1.0
 **/
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗在吃东西");
    }
}
