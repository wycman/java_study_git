package org.example;

/**
 * 取钱模拟
 */
public class withdraw {
    public static void main(String[] args) {
        SharedAccount sharedAccount = new SharedAccount("A123", "123456",
                100000);
        new Thread(new Runnable() {
            @Override
            public void run() {
            while(sharedAccount.getMoney() > 0) {
                sharedAccount.reentrantLock.lock();
                    if (sharedAccount.getMoney() < 40000) {
                        System.out.println(Thread.currentThread().getName() + "尝试取钱" + "但余额不足!");
                    } else {
                        sharedAccount.setMoney(sharedAccount.getMoney() - 40000);
                        System.out.println(Thread.currentThread().getName() + "成功取出40000元" + "余额为:" + sharedAccount.getMoney());
                    }
                sharedAccount.reentrantLock.unlock();
            }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(sharedAccount.getMoney() > 0) {
                    sharedAccount.reentrantLock.lock();
                        if (sharedAccount.getMoney() < 40000) {
                            System.out.println(Thread.currentThread().getName() + "尝试取钱" + "但余额不足!");
                        } else {
                            sharedAccount.setMoney(sharedAccount.getMoney() - 40000);
                            System.out.println(Thread.currentThread().getName() + "成功取出40000元" + "余额为:" + sharedAccount.getMoney());
                        }
                    sharedAccount.reentrantLock.unlock();
                }
            }
        }).start();
    }
}
