package com.biliedu.web_.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        // 1、客户端建立socket连接
//        Socket socket = new Socket("101.35.95.183", 9999); // 连接外网
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2、创建输出流, 将文件输入到传输通道中
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名：");
        String musci_name = scanner.next();
//        String musci_name = "稻香";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(musci_name);
        bw.flush();
        socket.shutdownOutput();

        // 3、接收文件
        // socket输入流
        InputStream is = socket.getInputStream();
        /** 文件输出流，将文件保存到客户端本地
         * 首先确定是不是存在文件名，然后考虑是否需要创建文件，再写入
         */
        String savePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/web_/homework/muc.mp3";
        File file = new File(savePath);
        if(file.exists()){
            System.out.println("文件存在，将会重写～");
        }else{
            System.out.println("文件不存在，创建文件中");
            if(file.createNewFile()){
                System.out.println("文件创建成功");
            }else{
                System.out.println("文件创建失败");
                throw new IOException();
            }
        }
        byte[] datas = new byte[1024];
        int len = 0;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        while ((len = is.read(datas)) != -1){
            bos.write(datas, 0, len);
        }
        System.out.println("文件保存本地成功～");

        // 4、客户端退出
        bos.close();
        is.close();
        bw.close();
        socket.close();

    }
}
