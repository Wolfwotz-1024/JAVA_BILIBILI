package com.biliedu.web_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket " + socket.getClass());
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
        socket.close();

    }
}
