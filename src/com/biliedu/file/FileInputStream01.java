package com.biliedu.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream01 {
    public static void main(String[] args) {
    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/news.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(filePath);
            while((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            fileInputStream.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/file/news.txt";
        int readData = 0;
        byte[] bytes = new byte[8];
        int byteLen = 0;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(filePath);
            while((byteLen = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, byteLen) + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            fileInputStream.close();
        }
    }
}
