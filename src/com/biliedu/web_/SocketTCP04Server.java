package com.biliedu.web_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP04Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端口 9999 启动");
        // 创建socket
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        String descPath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/web_/副本.jpg";
        File file = new File(descPath);
        if(file.exists()){
            System.out.println("文件已经存在， 正在重写中ing");
        }else{
            System.out.println("文件不存在，创建中ing～");
            if(file.createNewFile()){
                System.out.println("文件创建成功");
            }else{
                System.out.println("文件创建失败");
            }
        }

        FileOutputStream fi = new FileOutputStream(file);
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buff)) != -1){
            fi.write(buff, 0, len);
        }
        System.out.println("文件保存成功");


        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("收到图片～");
        bw.flush();
        socket.shutdownOutput();

        bw.close();
        fi.close();
        socket.close();
        serverSocket.close();



    }
}
