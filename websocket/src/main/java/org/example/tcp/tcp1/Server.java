package org.example.tcp.tcp1;

import org.example.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.TCP通信-服务端接收多条消息
 * 2.实现服务器可以同时接收多个客户端发来的消息(即多线程通信!)
 */
public class Server {
    //存储所有正在活跃的客户端socket
    public static List<Socket> live_sockets = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("------服务端启动中......");
       //注意TCP通信过程开启服务端需要使用serversocket
        ServerSocket serverSocket = new ServerSocket(6667);
        System.out.println("------服务端启动成功!");
        while (true) {
            Socket socket = serverSocket.accept();
            //加入list集合中
            live_sockets.add(socket);
            System.out.println("服务器与客户端:" + socket.getRemoteSocketAddress() + "成功建立通信!");
            new ServerThread(socket).start();
        }
    }
}
