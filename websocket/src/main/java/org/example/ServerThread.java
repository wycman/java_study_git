package org.example;

import org.example.tcp.tcp1.Server;

import java.io.*;
import java.net.Socket;

/**
 * 1.服务端线程，每一个线程与一个客户端建立通信并接收其发来的消息
 * 2.需要同时把消息发给所有客户端进程.
 */
public class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            SendToAll("客户端:" + socket.getRemoteSocketAddress() + "上线了!");
            while (true){
                String msg = null;
                System.out.println("---------");
                try {
                    msg = dataInputStream.readUTF();
                    SendToAll(socket.getRemoteSocketAddress() + "发来消息: " + msg);
                } catch (Exception e) {
                    System.out.println("客户端:" + socket.getRemoteSocketAddress() + "下线!");
                    //将已经关闭的socket从arraylist集合中去掉
                    Server.live_sockets.remove(socket);
                    dataInputStream.close();
                    socket.close();
                    break;
                }
                System.out.println("----当前线程:" + Thread.currentThread().getName());
                System.out.println("----当前客户端IP:" + socket.getRemoteSocketAddress());
                System.out.println("----当前客户端域名:" + socket.getInetAddress().getHostName());
                System.out.println("----发送的消息为:" + msg);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void SendToAll(String msg) throws IOException {
        for (Socket liveSocket : Server.live_sockets) {
            OutputStream outputStream = liveSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }
    }
}
