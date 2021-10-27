package com.biliedu.web_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端 端口 9999 服务启动");
        // 监听该端口，返回一个套接字
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] buff = new byte[1024];
        int buffLen = 0;
        while ((buffLen = inputStream.read(buff))!= -1){
            System.out.println(new String(buff, 0, buffLen));
        }

        System.out.println("服务器接收信息成功");

        Thread.sleep(1000);

//        accept = serverSocket.accept();
        System.out.println("服务器回发消息ing");
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello, client".getBytes(StandardCharsets.UTF_8));
        accept.shutdownOutput();
        inputStream.close();
        outputStream.close();
        System.out.println("回发消息成功，程序退出");
        accept.close();
        serverSocket.close();


    }
}
