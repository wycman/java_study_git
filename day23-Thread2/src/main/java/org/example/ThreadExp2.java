package org.example;

/**
 * 生产者消费者案例:(双线程通信)
 */
public class ThreadExp2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Producer());
        Thread thread2 = new Thread(new Consumer());
        thread1.start();
        thread2.start();
    }
}


class Producer implements Runnable{

    @Override
    public void run() {
        for(int i =0; i < 999; i++) {
            SharedRegion.reentrantLock.lock();
            if (SharedRegion.flag != false){
                try {
                    SharedRegion.c1.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("老板做了一碗乌冬面!");
            SharedRegion.flag = true;
            SharedRegion.c2.signal();
            SharedRegion.reentrantLock.unlock();
        }
    }
}

class Consumer implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 999; i++){
            SharedRegion.reentrantLock.lock();
            if (SharedRegion.flag != true){
                try {
                    SharedRegion.c2.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("园子吃了一碗乌冬面!");
            SharedRegion.flag = false;
            SharedRegion.c1.signal();
            SharedRegion.reentrantLock.unlock();
        }
    }
}