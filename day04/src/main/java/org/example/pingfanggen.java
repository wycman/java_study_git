package org.example;

import java.util.Scanner;

public class pingfanggen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int max_number = 0;
        for(;max_number * max_number < x;max_number++);
        System.out.println(max_number - 1);
    }
}
