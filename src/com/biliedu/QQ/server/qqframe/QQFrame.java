package com.biliedu.QQ.server.qqframe;

import com.biliedu.QQ.server.service.QQService;

/**
 * @Author SHKing
 * @Date 2021/10/30 12:39
 * @Version 1.0
 * 该类创建QQServer，启动后台程序
 */

public class QQFrame {

    public static void main(String[] args) {
        new QQService();
    }
}
