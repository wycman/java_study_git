package org.example;

public class Main {
    public static void main(String[] args) {
        test_monkey();
    }

    /**
     * 斐波那契数列案例
     */
    public static void test_fb() {


    }

    public static int fb_recursion(int num) {
        if(num <= 2)
            return 1;
        return fb_recursion(num - 1) + fb_recursion(num - 2);
    }

    /**
     * 猴子吃桃子案例
     */
    public static void test_monkey() {
        System.out.println(left_peach(1));
    }

    public static int left_peach(int day) {
        if(day == 10)
            return 1;
        return 2 * (left_peach(day + 1) + 1);
    }
}