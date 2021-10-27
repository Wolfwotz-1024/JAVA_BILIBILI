package com.biliedu.web_.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient01 {
    public static void main(String[] args) throws IOException {
        // 1、创建套接字
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接成功");
        // 2、创建输出流
        String str = "name";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(str);
        bw.flush();
        socket.shutdownOutput();

        // 3、接收服务器数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] chars = new char[1024];
        int len = 0;
        while ((len = br.read(chars))!=-1){
            System.out.println(new String(chars, 0, len));
        }
        System.out.println("客户端接收数据成功～");

        br.close();
        bw.close();
        socket.close();
        System.out.println("客户端退出程序");
    }
}
