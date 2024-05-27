package org.example;

public class fengqibiguo {
    public static void main(String[] args){
        for(int i = 1; i <= 10000; i++){
            if(i % 7 == 0){
                System.out.println(i);
                continue;
            }
            for(int x = i;x > 0;x /= 10){
                int cur_number = x % 10;
                if(cur_number == 7){
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}
