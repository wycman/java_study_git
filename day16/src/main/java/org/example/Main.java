package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        test_exception_example();
    }

    /**
     * 自定义异常练习
     */
    public static void test_exception_example(){
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[3];
        for(int i = 0; i < 3; i++){
            student[i] = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的信息：");
            while (true){
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                student[i].setName(name);
                String age_ipt, chn_score_ipt, math_score_ipt, eng_score_ipt;
                int age, chn_score, math_score, eng_score;
                try {
                    System.out.println("请输入学生年龄：");
                    age_ipt = scanner.next();
                    age = Integer.parseInt(age_ipt);
                } catch (NumberFormatException e){
                    System.out.println("年龄需为整数!");
                    continue;
                }
                try{
                    System.out.println("请输入学生语文成绩：");
                    chn_score_ipt = scanner.next();
                    chn_score = Integer.parseInt(chn_score_ipt);
                    System.out.println("请输入学生数学成绩：");
                    math_score_ipt = scanner.next();
                    math_score = Integer.parseInt(math_score_ipt);
                    System.out.println("请输入学生英语成绩：");
                    eng_score_ipt = scanner.next();
                    eng_score = Integer.parseInt(eng_score_ipt);
                } catch (NumberFormatException e){
                    System.out.println("成绩需为整数!");
                    continue;
                }
                try {
                    System.out.println("请输入学生年龄：");
                    student[i].setAge(age);
                    System.out.println("请输入学生语文成绩：");
                    student[i].setChn_score(chn_score);
                    System.out.println("请输入学生数学成绩：");
                    student[i].setMath_score(math_score);
                    System.out.println("请输入学生英语成绩：");
                    student[i].setEng_score(eng_score);
                    break;
                } catch (scoreException e) {
                    System.out.println(e.getMessage());
                } catch (ageException e){
                    System.out.println(e.getMessage());
                }

            }
        }


    }
}