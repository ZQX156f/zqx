package com.cskaoyan.work;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DemoOutputWrite {

    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("a.txt");

        String s = "aaa" + " ";

        // 先将数据转化为 byte[]
        byte[] bytes = s.getBytes();

        os.write(bytes);
        os.write(" ".getBytes());


    }
}
