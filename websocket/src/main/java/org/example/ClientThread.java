package org.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;
    public ClientThread(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while (true){
                String msg = null;
                System.out.println("---------");
                try {
                    msg = dataInputStream.readUTF();
                    System.out.println(msg);
                } catch (Exception e) {
                    System.out.println("客户端自身:" + socket.getRemoteSocketAddress() + "下线!");
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
