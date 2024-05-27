package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test_Shuangse();

    }

    private static void test02() {
        for(int i = 101; i <= 200; i++){
            if(is_SuShu(i))
                System.out.println(i);
        }
    }

    /**
     * 机票案例
     * @param ticket_Type
     * @param month
     * @param ticket_Price
     * @return
     */
    public static Float Calculate_Ticket(Integer ticket_Type, Integer month, Integer ticket_Price){
        //ticket_Type = 1代表为头等舱，ticket_Type = 0代表经济舱
        Float count = 1.0f;
        if(month >= 5 && month <= 10){
            count = ticket_Type == 1 ? 0.9f : 0.85f;
        }else if(month >= 11 || month <= 4){
            count = ticket_Type == 1 ? 0.7f : 0.65f;
        }else if(month < 0 || month > 12){
            System.out.println("Invalid month!");
            return -1.f;
        }
        return count * ticket_Price;
    }

    public static boolean is_SuShu(Integer x){
        boolean flag = true;
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 随机生成验证码
     */
    public static void test_VeryCode(){
        Random random = new Random();
        char[] a_Array = new char[52];
        for(char x = 'a'; x != 'z'; x++){
            a_Array[x -'a'] = x;
        }
        for(char x = 'A'; x != 'Z'; x++){
            a_Array[x -'A' + 26] = x;
        }
        String temp = "";
        for(int i = 0; i < 4; i++){
            int random_Idx = random.nextInt(52);
            temp += a_Array[random_Idx];
        }
        String final_Code = temp + random.nextInt(10);
        System.out.println(final_Code);
    }

    /**
     * 选手打分
     */
    public static void test_Dafen(){
        Random random = new Random();
        int[] scores = new int[6];
        float max_ = -10000.f;
        float min_ = 1000.f;
        float score = 0.0f;
        for(int i = 0; i < scores.length; i++) {
            scores[i] = random.nextInt(101);
            score += scores[i];
            if(scores[i] > max_) max_ = scores[i];
            if(scores[i] < min_) min_ = scores[i];
        }
        score = score - max_ - min_;
        System.out.println(score / (scores.length - 2));
    }

    /**
     * 解密，加密在此不再赘述，原理同解密
     */
    public static void test_Jiemi(){
        int number = 8346;
        int num_Numbers = 0;
        for(int x = number; x != 0; x /= 10, num_Numbers++);
        int[] numberArray = new int[num_Numbers];
        int res = 0;
        for(int x = number, i = 0; x != 0; x /= 10, i++){
            numberArray[i] = x % 10;
            if(numberArray[i] < 5)
                numberArray[i] = numberArray[i] + 10;
            numberArray[i] = numberArray[i] - 5;
            res = res * 10 + numberArray[i];
        }
        System.out.println(res);
    }

    /*
    抽奖小程序代码

     */
    public static void test_Choujiang() {
        Random random = new Random();
        String[] idx_To_Price = {"2", "588", "888", "1000", "10000"};
        int[] number_Count = {0, 0, 0, 0, 0};
        int max_Generation = idx_To_Price.length;
        int count_Generation = 0;
        while (true) {
            int temp_idx = random.nextInt(idx_To_Price.length);
            if(count_Generation == max_Generation)
                break;
            if(number_Count[temp_idx] > 0)
                continue;
            number_Count[temp_idx]++;
            System.out.println(idx_To_Price[temp_idx] + "的奖金被抽出");
        }
    }

    /**
     * 双色球中奖模拟
     */
    public static void test_Shuangse(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //随机生成中奖的红蓝球号码，分别用一个数组和一个int变量进行存储
        int[] Red = new int[6];
        int Blue = random.nextInt(16) + 1;
        int[] user_Red = new int[6];
        int user_Blue = 0;
        for(int i = 0; i < Red.length; i++){
            Red[i] = random.nextInt(33) + 1;
        }
        //用户输入自己的号码
        System.out.println("请依次输入您的红球号码!");
        int count_Red = 0;
        while(true){
            if(count_Red == Red.length)
                break;
            user_Red[count_Red] = scanner.nextInt();
            count_Red++;
        }
        System.out.println("请输入蓝球号码!");
        user_Blue = scanner.nextInt();
        //判断
        int is_Red = count_Red(Red, user_Red);
        int is_Blue = (Blue == user_Blue) ? 1 : 0;
        if(is_Red == 1){
            System.out.println("6等奖");
        }else if(is_Red == 2){
            if(is_Blue == 1)
                System.out.println("5等奖");
            else
                System.out.println("无");
        }else if(is_Red == 3){
            if(is_Blue == 1)
                System.out.println("5等奖");
            else
                System.out.println("无");
        }else if(is_Red == 4){
            if(is_Blue == 0)
                System.out.println("5等奖");
            else
                System.out.println("4等奖");
        }else if(is_Red == 5){
            if(is_Blue == 0)
                System.out.println("4等奖");
            else
                System.out.println("3等奖");
        }else{
            if(is_Blue == 0)
                System.out.println("2等奖");
            else
                System.out.println("1等奖");
        }
    }
    public static Integer count_Red(int[] Red, int[] user_Red){
        int count_Red = 0;
        for(int i=0; i<Red.length; i++){
            if(Red[i] == user_Red[i])
                count_Red++;
        }
        return count_Red;
    }
}