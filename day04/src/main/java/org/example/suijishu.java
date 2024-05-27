package org.example;

import java.util.Random;
import java.util.Scanner;

public class suijishu {
    public static void main(String[] args){
        Random r = new Random();
        int random_num = r.nextInt(100);
        System.out.println("Please enter the number you guess!");
        Scanner sc = new Scanner(System.in);
        int your_num = sc.nextInt();
        while(true){
            if(your_num == random_num){
                System.out.println("Yes!");
                break;
            }else if(your_num > random_num){
                System.out.println("A little larger!");
            }else{
                System.out.println("A little smaller!");
            }
            System.out.println("Please enter your number again!");
            your_num = sc.nextInt();
        }
    }
}
