package com.biliedu.web_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP04Client {
    public static void main(String[] args) throws IOException {
        // 1、创建文件输入流，读取文件
        String filePath = "/Users/guibintang/IdeaProjects/JAVA_BILIBILI/src/com/biliedu/web_/alibaba.jpg";
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // 2、将文件输入流得到的内容传输到socket的输出流
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端连接建立");
        OutputStream os = socket.getOutputStream();
        byte[] buff = new byte[1024];
        int buffLen = 0;
        while((buffLen = fileInputStream.read(buff)) != -1) {
            os.write(buff, 0, buffLen);
        }
        System.out.println("客户端上传文件.jpg完成");
        fileInputStream.close();
        socket.shutdownOutput();

        // 3、接收服务器返回的内容
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        br.close();
        os.close();
        socket.close();


    }
}
