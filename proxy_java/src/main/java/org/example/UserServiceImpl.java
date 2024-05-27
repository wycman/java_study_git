package org.example;

public class UserServiceImpl implements UserService{
    @Override
    public void addUser(String id, int age, String address) throws InterruptedException {
        System.out.println("添加一个用户!");
        //睡眠1秒
        Thread.sleep(1000);
    }

    @Override
    public void deleteUser(String id) throws InterruptedException {
        System.out.println("删除了一个用户!");
        Thread.sleep(1500);
    }

    @Override
    public void queryUser(String id) {
        System.out.println("查询到了该用户!");
    }
}
