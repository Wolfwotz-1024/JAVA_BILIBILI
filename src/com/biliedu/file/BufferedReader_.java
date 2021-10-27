package com.biliedu.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/node.txt";
        //创建BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
