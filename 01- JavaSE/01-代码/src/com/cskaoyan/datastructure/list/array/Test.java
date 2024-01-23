package com.cskaoyan.datastructure.list.array;

public class Test {

    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();
        // 按内容添加
        testContent(myArrayList);
        // 按下标
//        myArrayList.add(0, "1");
//        myArrayList.add(0, "2");
//
//        // 删除
//        myArrayList.remove(1);
//
//        myArrayList.set(0, "abcd");

    }

    private static void testContent(MyArrayList myArrayList) {
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");

        // 按内容删除
        myArrayList.remove("1");
        myArrayList.remove("6");
        myArrayList.remove("11");

        // 按内容修改
        myArrayList.set("8", "88");
    }
}
