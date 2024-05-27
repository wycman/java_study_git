package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数的整数:");
        int number = sc.nextInt();
        int hundred_pos = number / 100;
        int ten_pos = (number - hundred_pos * 100) / 10;
        int single_pos = number % 10;
        System.out.println("百分位: " + hundred_pos);
        System.out.println("十分位: " + ten_pos);
        System.out.println("个位: " + single_pos);
    }



}