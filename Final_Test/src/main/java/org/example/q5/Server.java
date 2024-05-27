package org.example.q5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

/**
 * **需求**
 *
 * 在实际开发中，很多系统都要完成用户登录和注册功能，但需要注意的是，用户注册的登录名和密码必须是发送给服务端进行保存的，**并且注册的登录名是不能重复的**，同时登录也是需要到服务端进行认证的。
 *
 * **功能点具体要求**
 *
 * 1、开发一个客户端，具备注册，和登录功能，除非用户输入exit，否则不退出这个界面。
 *
 * 2、注册功能要求：可以发送登录名和密码给服务端，服务端要响应是否注册成功的结果给客户端。如果注册没有问题，服务端需要将用户注册的登录名和密码保存到文件中去。（**注：是什么文件，可自行确定**）
 *
 * 3、登录功能要求：用户输入登录名和密码，需要发送给服务端，服务端认证后需要把登录的结果发送给客户端接收。
 *
 * **评分细则**
 *
 * * 能开发出客户端，并成功发送注册信息给服务端接收  4
 * * 服务端能接收注册信息，并成功写出去到属性文件中去 9
 * * 客户端能正确收到服务端响应的注册信息。 2
 * * 客户端能成功发出登录信息，服务端能成功收到  3
 * * 服务端能正确认证登录是否成功  4
 * * 客户端能收到登录后的结果。 2
 */
public class Server {
    //存储用户名与密码
    public static HashMap<String, String> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动中......");
        ServerSocket serverSocket = new ServerSocket(6667);
        System.out.println("服务端启动成功.....");
        Socket socket = serverSocket.accept();
        System.out.println("服务端与客户端的通信建立成功!");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        while (true){
            String msg = null;
            String head = null;
            String username = null;
            String password = null;
            try {
                head = dataInputStream.readUTF();
                username = dataInputStream.readUTF();
                password = dataInputStream.readUTF();
            } catch (Exception e) {
                System.out.println("与客户端:" + socket.getRemoteSocketAddress() + "连接已关闭!");
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();
                break;
            }
            System.out.println("客户端发来的消息为:" + head);
            System.out.println("客户端发来的账号为:" + username);
            System.out.println("客户端发来的密码为:" + password);
            String res = verify(head, username, password);
            System.out.println("抄送给客户端:" +
                    socket.getInetAddress().getHostName() + "的消息为:"
            + res);
            dataOutputStream.writeUTF(res);
            dataOutputStream.flush();
        }
    }

    public static String verify(String msg, String send_username, String send_password) throws IOException {
        if(msg.startsWith("注册")){
            if(hashMap.containsKey(send_username))
                return "注册失败:用户名已存在!";
            else {
                hashMap.put(send_username, send_password);
                //保存用户名和密码
                Properties properties = new Properties();
                properties.setProperty(send_username, send_password);
                properties.store(new FileWriter("Final_Test/src/main/resources/user.properties", true), "");
                return "注册成功";
            }
        }else{
            if(!hashMap.containsKey(send_username))
                return "登录失败:用户名不存在!";
            else {
                if(!hashMap.get(send_username).equals(send_password))
                    return "登录失败:密码输入错误!";
                else
                    return "登录成功!";
            }
        }
    }
}
