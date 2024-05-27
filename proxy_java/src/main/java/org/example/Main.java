package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserService userService = new UserServiceImpl();
        //创建对应的动态代理对象
        UserService userService1 = Proxy.CreateDynamicProxy(userService);
        userService1.addUser("1", 12, "123");
        userService1.deleteUser("1");
        userService1.queryUser("1");
    }
}