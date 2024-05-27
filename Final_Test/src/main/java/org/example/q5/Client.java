package org.example.q5;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("客户端启动中......");
        Socket socket = new Socket("127.0.0.1", 6667);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("客户端启动成功.....");
        //启动客户端线程接收
        new ClientThread("乃木园子的电脑", socket).start();
        while (true){
            System.out.println("1.登录!");
            System.out.println("2.注册!");
            System.out.println("3.输入exit退出客户端!");
            String flag = scanner.next();
            if(flag.equals("exit"))
                break;
            switch (Integer.parseInt(flag)){
                case 1 -> {
                    login(socket, dataOutputStream);
                    break;
                }
                case 2 -> {
                    Registe(socket, dataOutputStream);
                    break;
                }
                default -> {
                    break;
                }
            }
        }
        dataOutputStream.close();
        socket.close();
    }

    //客户端登录逻辑编写
    public static void login(Socket socket, DataOutputStream dataOutputStream) throws IOException {
        System.out.println("登录中......");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要登录的用户名!");
        String username = scanner.next();
        System.out.println("请输入要登录的密码!");
        String password = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("登录");
        String heads = new String(stringBuilder);
        dataOutputStream.writeUTF(heads);
        dataOutputStream.writeUTF(username);
        dataOutputStream.writeUTF(password);
        dataOutputStream.flush();
    }

    //客户端注册逻辑编写
    public static void Registe(Socket socket, DataOutputStream dataOutputStream) throws IOException {
        System.out.println("注册中......");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要注册的用户名!");
        String username = scanner.next();
        String password = null;
        System.out.println("请输入要注册的密码!");
        password = scanner.next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("注册");

        String heads = new String(stringBuilder);
        dataOutputStream.writeUTF(heads);
        dataOutputStream.writeUTF(username);
        dataOutputStream.writeUTF(password);
        dataOutputStream.flush();
    }
}
