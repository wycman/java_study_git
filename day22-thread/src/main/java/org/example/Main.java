package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Ticket_Sale_Window ticketSaleWindow1 = new Ticket_Sale_Window();
        Thread a = new Thread(ticketSaleWindow1, "A");
        Thread b = new Thread(ticketSaleWindow1, "B");
        Thread c = new Thread(ticketSaleWindow1, "C");
        b.start();
        a.start();
        c.start();
    }




}

class Mythread implements Runnable{


    @Override
    public void run() {

    }
}

class Mycallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int i = 0; i < 500; i++){
            System.out.println("线程执行第" + i + "次");
        }
        return "Yes";
    }

    /**
     * 多线程案例之电影院卖票
     */

}

/**
 * 多线程案例之电影院卖票
 */

class Ticket_Sale_Window implements Runnable{
    private int ticket = 22000;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
         {
            while (true) {
                try {
                    lock.lock();
                    if(ticket == 0)
                        break;
                    System.out.println(Thread.currentThread().getName() + "窗口卖出一张票, " +
                            "剩余票量为:" + ticket);
                    ticket--;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}