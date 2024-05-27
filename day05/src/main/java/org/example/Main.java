package org.example;

import java.util.Random;

public class Main {
    /**
     * 程序的主入口函数。
     * @param args 命令行传入的参数数组，本程序未使用该参数。
     */
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = {1, 2, 3, 4, 5};
        for(int i = 0; i < a.length; i++){
            int index = r.nextInt(a.length);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}