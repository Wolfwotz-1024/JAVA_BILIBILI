package com.biliedu.QQ.server.qqcommon;

import java.io.Serializable;

/**
 * @Author SHKing
 * @Date 2021/10/28 21:42
 * @Version 1.0
 * 表示客户端和服务端通信时的消息对象
 */

public class Message implements Serializable {
    private static final Long serialVersionUID = 1L; // 增强兼容性
    private  String sender; // 发送方
    private String getter; // 接收方
    private String content; // 发送内容
    private String sendTime; // 发送时间
    private String messType; // 消息类型【可以在接口中定义消息类型】


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
