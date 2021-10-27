package com.biliedu.web_.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer01 {
    public static void main(String[] args) throws IOException {
        // 1、创建服务器ServerSocket
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 监听 9999 端口～");
        // 2、创建连接套接字
        Socket socket = serverSocket.accept();

        // 3、服务端接收数据
//        InputStream inputStream = socket.getInputStream();
        char[] chars = new char[1024];
        int len = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while ((len = br.read(chars))!=-1){
            System.out.println(new String(chars, 0, len));
        }

        // 4、回发消息
        String str = "我是nova";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(str);
        bw.flush();
        socket.shutdownOutput();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器监听退出");


    }
}
