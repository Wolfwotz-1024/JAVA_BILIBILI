package com.biliedu.QQ.server.service;

import com.biliedu.QQ.client.qqcommon.Message;
import com.biliedu.QQ.client.qqcommon.MessageType;
import com.biliedu.QQ.client.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @Author SHKing
 * @Date 2021/10/30 11:19
 * @Version 1.0
 * 这是服务器 ，在监听9999，等待客户端的连接，并保持通信
 */

public class QQService {
    private ServerSocket ss = null;
    //  创建一个集合，存放多个用户，如果是这些用户登入，认为合法
    // 这里我们也可以使用ConcurrentHashMap，处理并发的集合

    private static HashMap<String, User> validUsers = new HashMap<>();

    static { // 初始化
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
    }

    // 验证用户
    private boolean checkUser(String userId, String passwd){
        User user = validUsers.get(userId);
        if(user == null){
            return false;
        }
        if(!user.getPasswd().equals(passwd)){
            return  false;
        }
        return true;
    }

    public QQService() {
        // 端口可以写在配置文件中
        try {
            System.out.println("服务端在9999端口监听");
            ss = new ServerSocket(9999);

            while(true){// 监听
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 得到socket关联的输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject(); // 读取客服端发送的user对象
                Message message = new Message();
                // 验证用户
                if(checkUser(u.getUserId(), u.getPasswd())){// pass
                    message.setMessType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //  将message对象回复
                    oos.writeObject(message);
                    // 创建一个线程，和客户端保持通信，该线程需要持有socket对象
                    ServerConnetClientThread serverConnetClientThread = new ServerConnetClientThread(socket, u.getUserId());
                    // 启动线程
                    serverConnetClientThread.start();
                    //把该线程对象放到集合中，进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnetClientThread);
                }else{ // fail
                    System.out.println("用户 id = " + u.getUserId() + " 验证失败");
                    message.setMessType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 如果服务器退出了while，关闭ServerSocket
            try {
                ss.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
