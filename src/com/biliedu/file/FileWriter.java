package com.biliedu.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) {

    }

    @Test
    public void operateFileWriter() throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/node.txt";
        String node = "风雨之后，定见彩虹";
        java.io.FileWriter fileWriter = null;
        try{
            fileWriter = new java.io.FileWriter(filePath);
            fileWriter.write(node);
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            fileWriter.close();
        }

    }
}
