package com.biliedu.web_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("服务端连接建立成功");

        // 创建输出流
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);
        osw.write("你好北京");
        osw.flush();
        socket.shutdownOutput();
        System.out.println("服务端发送消息完成！");

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
        osw.close();
        socket.close();
    }
}
