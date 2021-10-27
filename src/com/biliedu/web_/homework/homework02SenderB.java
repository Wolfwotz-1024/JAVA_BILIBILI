package com.biliedu.web_.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.next();
        String next = "四大名著是哪些";
        byte[] bytes1 = next.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(datagramPacket);


        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
    }
}
