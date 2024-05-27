package org.example;

import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int c = sc.nextInt();
        int x = c;
        int sum = 0;
        while(x > 0){
            int i = x % 10;
            sum = sum * 10 + i;
            x /= 10;
        }
        System.out.println(sum == c ? "为回文数":"不为回文数");
    }
}
