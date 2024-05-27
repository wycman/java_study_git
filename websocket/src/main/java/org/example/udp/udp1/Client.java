package org.example.udp.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.util.Scanner;

/**
 * UDP多发多收案例的客户端简单程序实现
 */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        System.out.println("客户端启动成功......");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的消息!(输入'exit'表示关闭服务!)");
            String to_send_msg = scanner.nextLine();
            if(to_send_msg.equals("exit"))
            {
                System.out.println("成功关闭服务!");
                datagramSocket.close();
                break;
            }
            DatagramPacket datagramPacket = new DatagramPacket(to_send_msg.getBytes(), to_send_msg.getBytes().length, Inet4Address.getLocalHost(), 6667);
            datagramSocket.send(datagramPacket);
            System.out.println("发送成功!");
        }

    }
}
