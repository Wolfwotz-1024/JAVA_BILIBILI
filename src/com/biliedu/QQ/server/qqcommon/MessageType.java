package com.biliedu.QQ.server.qqcommon;

/**
 * @Author SHKing
 * @Date 2021/10/28 21:48
 * @Version 1.0
 * 表示消息类型
 */

public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED = "1"; // 表示登入成功
    String MESSAGE_LOGIN_FAIL = "2"; // 表示登入失败
    String MESSAGE_COMM_MES = "3"; //  普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4"; // 要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIED = "5"; // 返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
}
