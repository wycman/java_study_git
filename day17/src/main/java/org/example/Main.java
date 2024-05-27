package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        test01();
    }
    public static void test01(){
    ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students,new Student(18,"张三"),new Student(19,"李四"),new Student(20,"王五"));
        Student max = Collections.max(students);
        System.out.println(max);
    }


}