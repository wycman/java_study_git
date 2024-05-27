package org.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟共享账户
 */
public class SharedAccount {
    ReentrantLock reentrantLock = new ReentrantLock();
    private String ID;
    private String password;
    private int money;

    public SharedAccount() {
    }

    public SharedAccount(String ID, String password, int money) {
        this.ID = ID;
        this.password = password;
        this.money = money;
    }

    /**
     * 获取
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    public String toString() {
        return "SharedAccount{ID = " + ID + ", password = " + password + ", money = " + money + "}";
    }
}
