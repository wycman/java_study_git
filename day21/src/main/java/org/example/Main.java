package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        test04();
    }


    /**
     * 对文本文件每行进行排序
     */
    public static void sort_file() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day21\\src\\main\\resources\\src.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("day21\\src\\main\\resources\\target.txt"));
        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {return Integer.parseInt(o1.split("\\.")[0])
                - Integer.parseInt(o2.split("\\.")[0]);
        });
        String line;
        while((line = bufferedReader.readLine()) != null){
            treeSet.add(line);
        }
        for (String s : treeSet) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    /**
     * 学生对象的读取与写入案例
     */
    public static void test02() throws IOException{
        Student stu1 = new Student("wyc", 23);
        Student stu2 = new Student("zrd", 23);
        Student stu3 = new Student("zmm", 22);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("day21\\src\\main\\resources\\students.txt"));
        ArrayList<Student> studentArrayList = new ArrayList<>();
        bufferedWriter.write(stu1.getName() + "-" + stu1.getAge());
        bufferedWriter.newLine();
        bufferedWriter.write(stu2.getName() + "-" + stu2.getAge());
        bufferedWriter.newLine();
        bufferedWriter.write(stu3.getName() + "-" + stu3.getAge());
        bufferedWriter.newLine();
        bufferedWriter.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day21\\src\\main\\resources\\students.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            studentArrayList.add(new Student(line.split("-")[0], Integer.parseInt(line.split("-")[1])));
        }
        studentArrayList.forEach((s) -> System.out.println(s));
    }

    /**
     * 序列化流写入并读取学生对象的案例
     * @throws IOException
     */
    public static void test03() throws IOException, ClassNotFoundException {
        Student stu1 = new Student("wyc", 23);
        Student stu2 = new Student("zrd", 23);
        Student stu3 = new Student("zmm", 22);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("day21\\src\\main\\resources\\students.txt"));
        ArrayList<Student> studentArrayList = new ArrayList<>();
        objectOutputStream.writeObject(stu1);
        objectOutputStream.writeObject(stu2);
        objectOutputStream.writeObject(stu3);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("day21\\src\\main\\resources\\students.txt"));
        while (true) {
            try {
                Object o = objectInputStream.readObject();
                studentArrayList.add((Student) o);
            } catch (EOFException e){
                break;
        }
        }
        studentArrayList.forEach((s) -> System.out.println(s));
        objectInputStream.close();
        objectOutputStream.close();
    }


    public static void test04() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("wyc", 21);
        hashMap.put("zrd", 22);
        Collection<Integer> values = hashMap.values();
        values.forEach((i) -> System.out.println(i));
    }
}