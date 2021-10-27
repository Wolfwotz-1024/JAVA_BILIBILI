package com.biliedu.web_;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        byte[] data = "hello 明天吃火锅~".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);

//        data = new byte[1024];
//        packet = new DatagramPacket(data, data.length);
        socket.receive(packet);
        int length = packet.getLength();
        byte[] data1  = packet.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);

        socket.close();
        System.out.println("B端退出");
    }
}
