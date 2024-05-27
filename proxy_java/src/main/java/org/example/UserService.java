package org.example;

public interface UserService {
    void addUser(String id, int age, String address) throws InterruptedException;
    void deleteUser(String id) throws InterruptedException;

    void queryUser(String id);
}
