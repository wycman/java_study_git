package org.example;

public class Main {
    public static void main(String[] args) {
        Coder new_coder = new Coder("张三", 18, 10000);
        new_coder.work();
        Manager manager = new Manager("wyc", 16, 19000000, 190000);
        manager.work();
    }
}