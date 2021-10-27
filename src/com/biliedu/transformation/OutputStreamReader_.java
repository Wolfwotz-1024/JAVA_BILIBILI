package com.biliedu.transformation;

import java.io.*;

public class OutputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/transformation/a.txt";
        String charset = "gbk";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charset);
        osw.write("hello, 腾讯字节");
        osw.close();
        System.out.println("保存文件成功！");
    }
}
