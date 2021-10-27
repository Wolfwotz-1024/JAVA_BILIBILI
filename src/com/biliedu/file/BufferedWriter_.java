package com.biliedu.file;

import java.io.*;
import java.io.FileWriter;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        // 创建BufferedWriter对象
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/test.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

        String context = "hello, Java!";
        bufferedWriter.write(context);
        bufferedWriter.write("\r\n");
        bufferedWriter.write("java 工程师");
        bufferedWriter.close();
    }
}
