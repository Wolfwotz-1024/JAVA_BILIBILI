package com.biliedu.web_.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        // 1、创建一个ServerSocket编程
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 端口 9999 监听中 ing ～ ");
        // 2、接收客户端的请求,创建socket套接字
        Socket socket = serverSocket.accept();

        // 3、接收文件，使用输入流
        byte[] bytes = new byte[1024];
        int len = 0;
        String res = "";
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        while((len = (bis.read(bytes))) != -1){
            res += new String(bytes, 0, len);
        }

        // 4、根据接收结果进行判断
        String rep_path = "";
        if("稻香".equals(res)){
            rep_path = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/web_/homework/稻香.mp3";
        }else{
            rep_path = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/web_/homework/See You Again.mp3";
        }

        // 5、从服务端的磁盘中读取文件返送到客户端
        byte[] buff = new byte[1024];
        int len1 = 0;
        FileInputStream fis = new FileInputStream(rep_path);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        while((len1 = fis.read(buff)) != -1){
            bos.write(buff, 0, len1);
        }
        socket.shutdownOutput();

        // 6、服务端结束任务
//        bos.close();
        fis.close();
        bis.close();
        socket.close();
        System.out.println("服务点任务结束");
    }
}
