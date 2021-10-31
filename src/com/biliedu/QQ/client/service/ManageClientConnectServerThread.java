package com.biliedu.QQ.client.service;

import java.util.HashMap;

/**
 * @Author SHKing
 * @Date 2021/10/29 22:47
 * @Version 1.0
 * 该类管理客户端连接到服务器的线程的类
 */

public class ManageClientConnectServerThread {
    // 我们把多个线程放到一个HashMap集合中，key就是用户id， value就是线程
    private static HashMap<String, ClientConnetServerThread> hm =
            new HashMap<>();

    // 将某个线程加到集合中
    public static void addClientConnetServerThread(String userId, ClientConnetServerThread clientConnetServerThread){
        hm.put(userId, clientConnetServerThread);
    }

    // 通过userId 得到对应线程
    public static ClientConnetServerThread getClientConnetServerThread(String userId){
        return hm.get(userId);
    }

}
