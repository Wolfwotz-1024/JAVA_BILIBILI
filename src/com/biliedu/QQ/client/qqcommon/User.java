package com.biliedu.QQ.client.qqcommon;

import java.io.Serializable;

/**
 * @Author SHKing
 * @Date 2021/10/28 21:41
 * @Version 1.0
 * 表示一个用户/客户信息
 */

public class User implements Serializable {

    private static final Long serialVersionUID = 1L; // 增强兼容性
    private String UserId; // 用户Id/用户名
    private String passwd; // 用户密码

    public User() {
    }

    public User(String userId, String passwd) {
        UserId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
