package com.biliedu.QQ.server.service;

import com.biliedu.QQ.client.qqcommon.Message;
import com.biliedu.QQ.client.qqcommon.MessageType;
import com.biliedu.QQ.client.qqcommon.User;
import com.biliedu.QQ.client.service.ManageClientConnectServerThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 * @Author SHKing
 * @Date 2021/10/30 11:35
 * @Version 1.0
 * 该类对象的对象和某个客户端保持通信
 */

public class ServerConnetClientThread extends Thread{
    private Socket socket;
    private String userId;

    public ServerConnetClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("服务端和客户端" + userId + "保持通信，读取数据...");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                // 后面根据message类型，做相应的业务处理
                if(message.getMessType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    // 客户端要在线用户列表
                    System.out.println(message.getSender() + " 要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    Message message1 = new Message();
                    message1.setMessType(MessageType.MESSAGE_RET_ONLINE_FRIED);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getSender());

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                }else if(message.getMessType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 退出");
                    // 将客户端 对应线程
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();
                    break;
                }else if(message.getMessType().equals(MessageType.MESSAGE_SENT_PRIVATE_CHAT)) {
                    ServerConnetClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                    oos.writeObject(message);
                }else if(message.getMessType().equals(MessageType.MESSAGE_SENT_TO_ALL_CHAT)){
                    //  得到当前所有在线用户的socket，然后循环写入
                    List<Socket> list = ManageClientThreads.getOnlineUserSocket(userId);
                    for (Socket socket1 : list) {
                        // 创建对象输出流
                        ObjectOutputStream oos = new ObjectOutputStream(socket1.getOutputStream());
                        oos.writeObject(message);
                    }
                }else{
                    System.out.println("其他类型的message，暂时不处理");
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
