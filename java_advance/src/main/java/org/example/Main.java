package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        zhengze_exp();
    }

    /**
     * 案例1---正则表达式匹配
     */
    public static void zhengze_exp(){
        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher("我在5:12准时起，13:14抽瑞克!");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }


    /**
     * 案例2---正则表达式匹配2
     */
    public static List<Integer> zhengze_exp2(){
        Pattern compile = Pattern.compile("\\d+");
        Matcher matcher = compile.matcher("我在5:12准时起，3242432413:14抽瑞克!");
        List<Integer> list = new ArrayList<>();
        while (matcher.find()) {
            System.out.println(matcher.group());
            list.add(Integer.parseInt(matcher.group()));
        }
        return list;
    }

}