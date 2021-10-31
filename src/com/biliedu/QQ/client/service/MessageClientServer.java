package com.biliedu.QQ.client.service;

import com.biliedu.QQ.client.qqcommon.Message;
import com.biliedu.QQ.client.qqcommon.MessageType;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author SHKing
 * @Date 2021/10/31 00:20
 * @Version 1.0
 */

public class MessageClientServer {
    public static void privateChar(String sender, String userId, String content) {
        // 首先创建一个message对象
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(userId);
        message.setContent(content);
        message.setMessType(MessageType.MESSAGE_SENT_PRIVATE_CHAT);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnetServerThread(sender).
                            getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(sender + " 对" + userId + "说：" + content);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void allChat(String sender, String content){
        //  创建一个message对象
        Message message = new Message();
        message.setSender(sender);
        message.setGetter("大家伙");
        message.setMessType(MessageType.MESSAGE_SENT_TO_ALL_CHAT);
        message.setContent(content);

        // 创建对象输出流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
                    .getClientConnetServerThread(sender).getSocket()
                    .getOutputStream());
            oos.writeObject(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
