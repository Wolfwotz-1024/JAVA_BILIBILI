package com.biliedu.web_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketTcp02Client {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        socket = new Socket(InetAddress.getByAddress("101.35.95.183".getBytes(StandardCharsets.UTF_8)), 9999);
        Socket socket = new Socket("101.35.95.183", 9999);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("链接链接理财");
        outputStream.write("hello, server".getBytes(StandardCharsets.UTF_8));
        // 设置一个结束标记
        socket.shutdownOutput();
        System.out.println("客户端发送消息成功");
        InputStream inputStream = socket.getInputStream();

        byte[] buff = new byte[1024];
        int buffLen = 0;
        while ((buffLen = inputStream.read(buff)) != -1){
            System.out.println(new String(buff, 0, buffLen));
        }

        inputStream.close();
        outputStream.close();
        System.out.println("客户端程序结束，退出");
    }
}
