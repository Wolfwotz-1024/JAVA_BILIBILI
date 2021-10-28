package com.biliedu.QQ.client.view;

import java.util.Scanner;

/**
 * @Author SHKing
 * @Date 2021/10/28 21:54
 * @Version 1.0
 * 客户端的菜单页面
 */

public class QQView {
    private boolean loop = true; // 控制是否显示菜单
    private String key = ""; // 接收用户的输入


    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }

    // 显示主菜单
    private void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("============欢迎登陆网络通信系统============");
            System.out.println("\t\t 1 登陆系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择：");
            key = scanner.next();

            // 根据用户的不同输入，完成不同的逻辑
            switch (key){
                case "1":
                    System.out.println("请输入用户名：");
                    String userId = scanner.next();
                    System.out.println("请输入密码：");
                    String passwd = scanner.next();
                    // 接下来需要去验证该用户是否合法
                    if(false){
                        System.out.println("============欢迎（用户 " +  userId + "）============");
                        // 进入二级菜单
                        while(loop){
                            System.out.println("\n============网络通信系统二级菜单（用户 " +  userId + "）============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");

                            key = scanner.next();

                            switch (key){
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("======登入失败======");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
            }
        }
    }
}
