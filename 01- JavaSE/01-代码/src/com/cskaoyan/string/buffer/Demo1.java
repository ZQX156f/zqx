package com.cskaoyan.string.buffer;

public class Demo1 {

    public static void main(String[] args) {

        String str = "";

        StringBuffer sb = new StringBuffer();
        // 获取当前时间戳
        long start = System.currentTimeMillis();
        //int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            //str += "a";
            // sum+=i;
            sb.append("a");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
