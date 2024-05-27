package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 送礼品案例
 */
public class ThreadExp3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SharedGifts sharedGifts = new SharedGifts(100, 0, 0);
        FutureTask<Integer> futureTask1 = new FutureTask<>(new Callable<Integer>(){
            private int xm = 0;
            @Override
            public Integer call() throws Exception {
                while (sharedGifts.getGifts() > 10){
                    synchronized (sharedGifts) {
                        if(sharedGifts.getGifts() > 10) {
                            System.out.println(Thread.currentThread().getName() + "送出一份礼品!");
                            sharedGifts.setGifts(sharedGifts.getGifts() - 1);
                            xm++;
                            sharedGifts.setXm(sharedGifts.getXm() + 1);
                        }
                    }
                }
                return xm;
            }
        });
        new Thread(futureTask1).start();

        FutureTask<Integer> futureTask2 = new FutureTask<>(new Callable<Integer>(){

            private int xm = 0;
            public Integer call() throws Exception {
                while (sharedGifts.getGifts() > 10){
                    synchronized (sharedGifts) {
                        if(sharedGifts.getGifts() > 10) {
                            System.out.println(Thread.currentThread().getName() + "送出一份礼品!");
                            sharedGifts.setGifts(sharedGifts.getGifts() - 1);
                            xm++;
                            sharedGifts.setXh(sharedGifts.getXh() + 1);
                        }
                    }
                }
                return xm;
            }
        });
        new Thread(futureTask2).start();

        System.out.println("小明送出" + futureTask1.get() + "份礼物!");
        System.out.println("小红送出" + futureTask2.get() + "份礼物!");
        System.out.println(sharedGifts.getXm());
        System.out.println(sharedGifts.getXh());
        System.out.println("还剩:" + sharedGifts.getGifts() + "份礼物!");
    }
}
