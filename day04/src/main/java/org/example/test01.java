package org.example;

public class test01 {
    public static void main(String[] args){
        int shang = 0;
        int bc = 35, c = 4;
        while(bc >= c){
            bc -= c;
            shang++;
        }
        System.out.println("商为:" + shang +"，余数为:" + bc);
    }
}
