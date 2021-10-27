package com.biliedu.stream_;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/stream_/mytemp";
        File file = new File(filePath);
        if(!file.exists()){
            if(file.mkdirs()){
                System.out.println("创建 " + filePath + " 创建成功");
            }else{
                System.out.println("创建 " + filePath + " 创建失败");
            }
        }
        String fileL = filePath + "/hello.txt";
        File file1 = new File(fileL);
        if(file1.exists()){
            System.out.println("文件已经存在");
        }else{
            if(file1.createNewFile()) {
                System.out.println("文件创建成功");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                bw.write("helloworld");
                bw.close();
                System.out.println("文件写入成功！");
            }else{
                System.out.println("文件创建失败");
            }
        }


    }
}
