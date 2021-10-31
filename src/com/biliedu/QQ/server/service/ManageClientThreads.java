package com.biliedu.QQ.server.service;

import java.net.Socket;
import java.util.*;

/**
 * @Author SHKing
 * @Date 2021/10/30 12:21
 * @Version 1.0
 * 该类用于管理和客户端通信的线程
 */

public class ManageClientThreads {
    private static HashMap<String, ServerConnetClientThread> hm= new HashMap<>();

    // 添加线程对象到集合中
    public static void addClientThread(String userId, ServerConnetClientThread serverConnetClientThread){
        hm.put(userId, serverConnetClientThread);
    }

    // 根据userId， 返回 serverConnectClientThread线程
    public static ServerConnetClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    // 从集合移除某个线程对象
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    // 编写方法，返回在线用户列表
    public static String getOnlineUser(){
        //  集合遍历
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while(iterator.hasNext()){
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

    //  编写方法，返回所有在线用户的socket对象
    public static List<Socket> getOnlineUserSocket(String userId){
        // 遍历集合
        List<Socket> list = new ArrayList<>();
        Iterator<String> iterator = hm.keySet().iterator();
        while(iterator.hasNext()){
            String uId = iterator.next();
            if(!userId.equals(uId)){
                list.add(hm.get(uId).getSocket());
            }
        }
        return list;
    }
}
