package com.biliedu.QQ.client.service;

import com.biliedu.QQ.client.qqcommon.Message;
import com.biliedu.QQ.client.qqcommon.MessageType;
import com.biliedu.QQ.client.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author SHKing
 * @Date 2021/10/29 21:12
 * @Version 1.0
 */

public class UserClientService {

    private User u =  new User();
    private Socket socket;
    // 根据UserId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd){
        boolean b = false;
        // 创建 User 对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        // 连接到服务器验证
        try {
//            socket = new Socket("101.35.95.183", 9999);
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            // 读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if(ms.getMessType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){ // 登入成功
                b = true;
                // 创建一个和服务亲端保持通信的线程 -》 创建一个类 ClientConnetServerThread
                ClientConnetServerThread clientConnetServerThread = new ClientConnetServerThread(socket);
                // 启动客户端进程
                clientConnetServerThread.start();
                // 这里为了后面客户端的拓展，我们将线程放到集合中管理
                ManageClientConnectServerThread.addClientConnetServerThread(userId, clientConnetServerThread);


            }else{
                // 如果登入失败，我们就不能启动线程，需要关闭socket
                socket.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    // 向服务器端请求在线用户列表
    public void onLineFriendList(){
        Message message = new Message();
        message.setSender(u.getUserId());
        message.setMessType(MessageType.MESSAGE_GET_ONLINE_FRIEND);

        // 发送服务器
        // 应该得到当前线程的Socket 对应的 输出流
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getClientConnetServerThread(
                            u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //  编写方法，退出客户端，并给服务器发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMessType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        
        // 发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统 ");
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
