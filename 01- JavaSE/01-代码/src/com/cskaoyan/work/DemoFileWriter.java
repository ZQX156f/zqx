package com.cskaoyan.work;

import javax.annotation.processing.Filer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DemoFileWriter {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("a.txt");
        // 实现追加写入
        FileWriter fileWriter = new FileWriter("a.txt", true);

        //
    }
}
