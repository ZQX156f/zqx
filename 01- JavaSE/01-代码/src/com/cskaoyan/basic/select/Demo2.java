package com.cskaoyan.basic.select;

/*
        switch 语句

        switch(expression){
            case value1:
            statement1;
            break;
            case value2:
            statement2;
            break;
            ...
                default:
            statement;
            break;
         }
       case穿越问题：
        1. 正常情况下，每一个case都应该有一个break，用来限制case中statement的执行范围
        2. 当省略掉某个case中的break后，statement就会按照顺序一直被执行
        3. 这个时候statement的执行不仅限于自身case了，这个过程会持续到switch结束或者碰到一个break
        4. 灵活使用case穿越可以简化代码，比如月份和季节的案例
 */
public class Demo2 {

    public static void main(String[] args) {

        int i = 10;

//        switch (i) {
//            default:
//                System.out.println("不是0,1,2");
//            case 0:
//                System.out.println("0");
//            case 1:
//                System.out.println("1");
//            case 2:
//                System.out.println("2");
//                break;
//
//        }

        // main
//        int x = 2;
//        int y = 3;
//        switch(x){
//            default:
//                y++;
//                break;
//            case 3:
//                y++;
//            case 4:
//                y++;
//        }
//        System.out.println("y="+y);


        // main
        int x = 2;
        int y = 3;
        switch(x){
            default:
                y++;
            case 3:
                y++;
            case 4:
                y++;
        }
        System.out.println("y="+y);
    }
}
