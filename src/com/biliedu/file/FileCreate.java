package com.biliedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    public void create01() throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/news1.txt";
        File file = new File(filePath);
        file.createNewFile();
    }

    @Test
    public void create02() throws IOException {
        File parenFile = new File("/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src");
        String fileName = "news2.txt";
        File file = new File(parenFile, fileName);
        file.createNewFile();
    }

    @Test
    public void create03() throws IOException {
        String parentPath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src";
        String filePath = "news3.txt";
        File file = new File(parentPath, filePath);
        file.createNewFile();
    }
}
