package org.example;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抽奖小程序案例模拟
 */
public class ThreadExp4 {
    public static void main(String[] args) throws UnknownHostException {
    //定义抽奖奖池
        List<Integer> shared_prizes = new ArrayList<>();
        shared_prizes.add(10);
        shared_prizes.add(20);
        shared_prizes.add(30);
        shared_prizes.add(400);
        shared_prizes.add(600);
        shared_prizes.add(900);
        shared_prizes.add(1000);
        shared_prizes.add(1000);
        shared_prizes.add(1000);
        for(int i = 0; i < 2000; i++)
            shared_prizes.add(65);
        shared_prizes.add(100000000);
        shared_prizes.add(200000000);
        shared_prizes.add(300000000);
        Random random = new Random();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(shared_prizes.size() > 0){
                        synchronized (shared_prizes) {
                            if(shared_prizes.size() > 0){
                                int cur_pri = shared_prizes.remove(random.nextInt(shared_prizes.size()));
                                System.out.println("恭喜" + Thread.currentThread().getName() + "抽到" + cur_pri + "元大奖!");
                            }else
                                break;
                        }
                    }else
                        break;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(shared_prizes.size() > 0){
                        synchronized (shared_prizes) {
                            if(shared_prizes.size() > 0){
                                int cur_pri = shared_prizes.remove(random.nextInt(shared_prizes.size()));
                                System.out.println("恭喜" + Thread.currentThread().getName() + "抽到" + cur_pri + "元大奖!");
                            }else
                                break;
                        }
                    }else
                        break;
                }
            }
        }).start();
        InetAddress ip1 = Inet4Address.getByName("www.baidu.com");
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

    }
}
