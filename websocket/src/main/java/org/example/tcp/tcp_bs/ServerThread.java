package org.example.tcp.tcp_bs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
    this.socket = socket;
    }
    public void run(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            //服务端向浏览器相应http规定的格式
            PrintStream printStream = new PrintStream(outputStream);
            printStream.print("HTTP/1.1 200 OK");
            printStream.println();
            printStream.println("Content-Type:text/html;charset=UTF-8");
            printStream.println();
            printStream.print("<div style='color:blue;font-size:130px;text-align:center'>乃木园子很可爱</div>");
            printStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
