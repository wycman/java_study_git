package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享区
 * 共享锁lock以及布尔类型的标记变量flag
 */
public class SharedRegion {
    public static boolean flag = false;
    public static ReentrantLock reentrantLock = new ReentrantLock();


    public static Condition c1 = reentrantLock.newCondition();
    public static Condition c2 = reentrantLock.newCondition();
}
