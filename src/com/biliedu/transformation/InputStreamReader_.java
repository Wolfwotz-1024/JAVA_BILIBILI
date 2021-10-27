package com.biliedu.transformation;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/transformation/a.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader bufferedReader = new BufferedReader(isr);
        char[] chars = new char[20];
        int len = 0;
        while ((len = isr.read(chars))!=-1){
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
//        String s = bufferedReader.readLine();
//        System.out.println(s);
        bufferedReader.close();

    }
}
