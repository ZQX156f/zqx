package com.cskaoyan.exception;

/*

        try {

        } catch() {

        } finally {
            //被finally控制的语句体一定会执行
        }

        finally: 执行特征，必执行，除非在fianlly执行前，终止了jvm的执行(比如System.exit(0) )

        作用
            用于释放资源，在IO流操作和数据库操作中会见到



 */

public class Demo7 {

    public static void main(String[] args) {

        /*
            finally代码块必执行的特征
         */
        //testRun();


        // 介绍使用场景
        //situation();

        // 当执行return i, finally是在return语句的中间执行
        //int i = testFinally();
        //System.out.println(i);

        // try出现异常，finally中有return
        try {
           int i = 1 / 0;
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("hello, finally");
            return;
        }

    }


    public static int testFinally() {

        int i = -1;

        try {
            i = 10;
            int j = i / 0;
        } catch (Exception e) {
            i = 100;
            return i;
        } finally {
            i = 200;
            System.out.println("hello, finally");
            return i;
        }
    }

    private static void situation() {
        try {
            // 申请了一些系统资源
            // 使用系统资源
        } catch (Exception e) {

        } finally {
            // 释放系统资源
        }
    }

    private static void testRun() {
        try {

            int i = 0;
            // 除0异常
            //int j = 10 / i;
            System.out.println("try");
            //return;

            // 终止jvm
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("hello, finally");
        }
    }
}
