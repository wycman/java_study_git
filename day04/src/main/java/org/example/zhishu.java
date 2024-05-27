package org.example;

import java.util.Scanner;

public class zhishu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要判断的整数:");
        int x = sc.nextInt();
        int i = x/2;
        for(;x % i != 0;i--);
        System.out.println(x + (i > 1?"不是质数":"是质数"));
    }
}
