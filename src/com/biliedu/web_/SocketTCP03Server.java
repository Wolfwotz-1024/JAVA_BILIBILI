package com.biliedu.web_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务启动，监听端口号 ： 9999");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

         //  将字节流转换为字符流
        InputStreamReader isr = new InputStreamReader(inputStream);
        char[] buff = new char[1024];
        int buffLen = 0;
        while ((buffLen = isr.read(buff)) != -1){
            System.out.println(new String(buff, 0, buffLen));
        }
        System.out.println("服务端接收消息完成");

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bfr = new BufferedWriter(new OutputStreamWriter(outputStream));
        bfr.write("你好用户端");
        bfr.flush();
        socket.shutdownOutput();
        System.out.println("服务端以响应");

        isr.close();
        bfr.close();
        socket.close();
        serverSocket.close();


    }
}
