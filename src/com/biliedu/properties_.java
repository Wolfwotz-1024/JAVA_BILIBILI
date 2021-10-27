package com.biliedu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class properties_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("IP", "192.168.110.100");
        properties.setProperty("user", "SHKing");
        properties.setProperty("pwd", "123456");

        properties.store(new FileWriter("/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/transformation/b.properties"), null);
        System.out.println("配置文件保存成功！");
    }
}
