package org.example.q5;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public ClientThread(String name, Socket socket) {
        super(name);
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //接受客户端发来的登录消息
            while (true) {
                try {
                    String msg = dataInputStream.readUTF();
                    System.out.println("服务器发来的消息为:" + msg);
                } catch (IOException e) {
                    System.out.println("客户端" + socket.getRemoteSocketAddress() + "关闭!");
                    dataInputStream.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
