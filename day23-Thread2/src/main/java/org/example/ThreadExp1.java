package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExp1 {
    /**
     * 三个线程相互通信的案例
     * @param args
     */
    public static void main(String[] args) {
        PrinterImpl printer = new PrinterImpl();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 500; i++) {
                        printer.print_s1();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 500; i++) {
                        printer.print_s2();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 500; i++) {
                    printer.print_s3();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class PrinterImpl{
    ReentrantLock reentrantLock = new ReentrantLock();

    Condition condition1 = reentrantLock.newCondition();
    Condition condition2 = reentrantLock.newCondition();
    Condition condition3 = reentrantLock.newCondition();

    private int flag = 1;
    public void print_s1() {
        reentrantLock.lock();
        while(flag != 1) {
            try {
                condition1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("乃");
        System.out.print("木");
        System.out.print("园");
        System.out.print("子");
        System.out.print("第");
        System.out.print("一");
        System.out.print("可");
        System.out.print("爱");
        System.out.println();

        flag = 2;
        condition2.signal();
        reentrantLock.unlock();
    }

    public void print_s2() {
        reentrantLock.lock();
       while(flag != 2) {
            try {
                condition2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("乃");
        System.out.print("木");
        System.out.print("园");
        System.out.print("子");
        System.out.print("一");
        System.out.print("点");
        System.out.print("都");
        System.out.print("不");
        System.out.print("可");
        System.out.print("爱");
        System.out.println();

        flag = 3;
        condition3.signal();
        reentrantLock.unlock();
    }

    public void print_s3() {
        reentrantLock.lock();
        while(flag != 3) {
            try {
                condition3.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("*");
        System.out.print("*");
        System.out.print("*");
        System.out.print("乃");
        System.out.print("木");
        System.out.print("园");
        System.out.print("子");
        System.out.print("超");
        System.out.print("级");
        System.out.print("可");
        System.out.print("爱");
        System.out.print("!");
        System.out.println();

        flag = 1;
        condition1.signal();
        reentrantLock.unlock();
    }
}