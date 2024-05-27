package org.example.tcp.tcp1;

import org.example.ClientThread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.TCP通信-客户端发送多条消息
 * 2.需要能够将消息发送给自身以及其他客户端
 * 3.客户端既需要发送消息又需要接收消息
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("-----客户端启动中......");
        Socket socket = new Socket("127.0.0.1", 6667);
        new ClientThread(socket).start();
        System.out.println("-----客户端启动成功!");
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //开启一个接收其他客户端发来消息的新线程!
        try {
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入要待发送的消息!(请注意输入'exit'表示退出客户端发送进程!)");
                String msg = scanner.nextLine();
                if(msg.equals("exit")) {
                    System.out.println("客户端退出服务成功!");
                    break;
                }
                dataOutputStream.writeUTF(msg);
                System.out.println("消息发送成功!");
            }
        } finally {
            dataOutputStream.close();
            socket.close();
        }

    }
}
