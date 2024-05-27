package org.example.udp.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP多发多收的服务端简单程序案例
 */
public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(6667);
        System.out.println("服务端启动成功......");
        byte[] receive_bytes = new byte[1024 * 64];
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(receive_bytes, receive_bytes.length);
            datagramSocket.receive(datagramPacket);
            String received_mes = new String(receive_bytes, 0, datagramPacket.getLength());
            System.out.println("发送消息的客户端ipv4地址为:" + datagramPacket.getAddress().getHostAddress());
            System.out.println("发送消息的客户端主机域名为:" + datagramPacket.getAddress().getHostName());
            System.out.println("客户端发来的消息为:" + received_mes);
        }
    }
}
