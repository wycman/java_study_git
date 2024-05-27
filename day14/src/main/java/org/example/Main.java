package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
    test04();
    }
    /**
     * 包装类测试!
     */
    public static void test01(){
        String s = "12,13,14,15";
        //使用split函数分割字符串到一个字符串数组中
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(split[i]);
            System.out.println(arr[i]);
        }
    }

    /**
     * 正则表达式练习
     */
    public static void test02(){
        //定义手机号匹配规则
        String regex = "[1][3-9]\\d{9}";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入手机号!");
        String str = scanner.next();
        System.out.println(str.matches(regex) ? "yes!":"no");

    }

    /**
     * 日期练习：计算我来到了这个世界上多少天
     */
    public static void test03() throws ParseException {
        //定义一个simpleFormat类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出生年月日!");
        String birth_str = scanner.next();
        Date date = simpleDateFormat.parse(birth_str);
        //获取从输入的出生年月日到现在经过了多少毫秒
        long time = new Date().getTime() - date.getTime();
        System.out.println(time / 1000 / 60 / 60 / 24);
    }

    /**
     * 小案例:判断2025年3月1日是否为疯狂星期四
     */
    public static void test04() {
        Calendar calendar = Calendar.getInstance();
        //3月份在calendar中应设置为2
        calendar.set(2025, 2, 1);
        //通过calendar对象获取2025年3月1日的dayofweek
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        //如果为星期四则返回的下标为5
        if (dayofweek == 5) {
            System.out.println("是疯狂星期四");
        } else {
            System.out.println("不是疯狂星期四");
        }
    }
}