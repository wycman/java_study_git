package org.example.tcp.tcp_bs;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池优化BS架构
 */

public class Server {
    public static void main(String[] args) throws IOException {
        //使用线程池优化BS架构
        ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(
                2,
                5,
                20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        System.out.println("------服务端启动中!");
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("------服务端启动成功!");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("服务端成功建立起与主机:" + socket.getRemoteSocketAddress() + "的连接!");
            threadPool1.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("当前线程为:" + Thread.currentThread().getName());
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
            });
        }
    }
}
