package com.biliedu.stream_;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = null;
        int lineNum = 0;
        while((line = br.readLine()) != null){
            System.out.println(++lineNum + line);
        }
        br.close();
    }
}
