package com.biliedu.web_.homework;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        System.out.println("A 在 8888 端口监听");

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(packet);


        int len = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, data.length);
        System.out.println(s);
        String answer = "";
        if("四大名著是哪些".equals(s)){
            answer = "四大名著是<红楼梦>...";
        }else{
            answer = "what";
        }

        packet= new DatagramPacket(answer.getBytes(StandardCharsets.UTF_8), answer.length(), InetAddress.getLocalHost(), 9999);
        datagramSocket.send(packet);


    }
}
