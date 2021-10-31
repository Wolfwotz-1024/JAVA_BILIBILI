package com.biliedu.QQ.client.service;

import com.biliedu.QQ.client.qqcommon.Message;
import com.biliedu.QQ.client.qqcommon.MessageType;
import com.sun.security.ntlm.Client;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Author SHKing
 * @Date 2021/10/29 21:29
 * @Version 1.0
 */

public class ClientConnetServerThread extends Thread{
    // 该线程需要持有Socket
    private Socket socket;

    public ClientConnetServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程，等到从服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务器没有发送Message对象，线程会阻塞在这里
                Message message = (Message) ois.readObject();

                //判断的message类型
                if (message.getMessType().equals(MessageType.MESSAGE_RET_ONLINE_FRIED)) {
                    // 取出在线列表信息，并显示
                    // 规定
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n======当前在线用户列表======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户： " + onlineUsers[i]);
                    }
                }else if(message.getMessType().equals(MessageType.MESSAGE_SENT_PRIVATE_CHAT) ||
                        message.getMessType().equals(MessageType.MESSAGE_SENT_TO_ALL_CHAT)) {
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter()
                            + " 说：" + message.getContent());
                }else{
                    System.out.println("是其他类型，暂不处理。。。");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 为了方便得到socket
    public Socket getSocket(){
        return socket;
    }
}
