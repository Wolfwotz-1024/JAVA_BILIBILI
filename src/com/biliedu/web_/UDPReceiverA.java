package com.biliedu.web_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 1、创建一个 DatagramSocket对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        // 2、构建一个 DatagramPacket对象，准备接收数据
        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        // 3、调用 接收方法,将通过网络传输的 DatagramPacket 对象填充到packet对象
        System.out.println("接收端在 9999 端口等待接收数据～");
        socket.receive(packet);
        // 4、可以把packet 进行拆包，取出数据，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();

        String s = new String(data, 0, length);
        System.out.println(s);

        // 下面发送数据
        buff = "好的，明天见".getBytes(StandardCharsets.UTF_8);
        packet = new DatagramPacket(buff, buff.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet);

        socket.close();
        System.out.println("A端退出");
    }

}
