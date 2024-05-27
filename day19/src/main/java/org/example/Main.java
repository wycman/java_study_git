package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    //定义一个静态变量用于存储无后缀名的文件个数s
    static int count_num = 0;

    public static void main(String[] args) throws IOException {
        File dir = getDir();
        HashMap<String, Integer> hashMap = new HashMap<>();
        get_file_num(hashMap, dir);
        hashMap.entrySet().stream().filter(
                (entry) -> {
                    return entry.getKey().equals("jpg");
                }
        ).forEach((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println("无后缀名文件个数为:" + " " + count_num);
    }

    /**
     * File类案例
     */
    public static void test01() throws IOException {
        File file = new File("day19\\src\\main\\resources");
        //创建一个文件
        file.createNewFile();
        long time = file.lastModified();
        Date date = new Date(time);
        System.out.println(date.toString());
    }

    /**
     * 键盘录入一个文件夹案例，如果输入错误则重复循环，否则提示并结束
     */
    public static File getDir(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径!");
        String path_string = scanner.nextLine();
        File dir1 = new File(path_string);
        while (true){
            if(dir1.exists() && dir1.isDirectory())
                break;
            else{
                System.out.println("输入路径有误，请重新输入!");
                path_string = scanner.nextLine();
                dir1 = new File(path_string);
            }
        }
        return dir1;
    }

    /**
     * 键盘录入一个多级文件夹，并找出这个多级文件夹下的所有后缀为.java的文件
     * 思路?
     * 应当使用递归调用函数并打印出所有文件夹下的子文件夹中所有后缀为java的所有java文件
     */
    public static void get_java_in_all_dir(File f){
        if(f.isFile() && ! f.getName().endsWith("java"))
            return;
        if(f.isFile() && f.getName().endsWith("java")) {
            System.out.println(f.getName());
            return;
        }
        if(f.listFiles() == null)
            return;
        for (File file : f.listFiles()) {
            get_java_in_all_dir(file);
        }

    }
    public static void test02() {
        File dir = getDir();
        get_java_in_single_dir(dir);
    }

    /**
     * 键盘录入一个单级文件夹，并找出这个单级文件夹下所有文件后缀为java的
     * java文件并打印输出
     * @param dir
     */
    private static void get_java_in_single_dir(File dir) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if(file.isFile() && file.getName().endsWith("java"))
                arrayList.add(file.getName());
        }
        arrayList.forEach(s -> System.out.println(s));
    }

    /**
     * 删除一个文件夹中所有文件以及空文件夹
     */
    public static void delete_all(File dir){
        if(dir.isFile()) {
            dir.delete();
            return;
        }
        for (File file : dir.listFiles()) {
            delete_all(file);
        }
        dir.delete();
    }

    /**
     * 统计一个文件夹中所有文件的大小之和
     */
    public static long cal_dir_size(File dir){
        if(dir.isFile())
            return dir.length();
        long sum = 0;
        for (File file : dir.listFiles()) {
            sum += cal_dir_size(file);
        }
        return sum;
    }

    /**
     * 键盘录入一个文件夹路径，统计该文件夹中每种文件的个数并打印
     */
    public static void get_file_num(HashMap<String, Integer> hashMap, File dir) {
        if (dir.isFile()) {
            if(dir.getName().contains(".")) {
                String[] s = dir.getName().split("\\.");
                String file_type = s[s.length - 1];
                if (hashMap.containsKey(file_type)) {
                    hashMap.put(file_type, hashMap.get(file_type) + 1);
                } else {
                    hashMap.put(file_type, 1);
                }
            }else
                count_num++;
            return;
        }

        // 确保dir是目录后再尝试获取子文件列表
        File[] files = dir.listFiles();
        if (files != null) { // 防止null指针异常，当dir为空目录时files可能为null
            for (File file : files) {
                get_file_num(hashMap, file); // 递归调用，无需再次检查file是否为目录
            }
        }
    }
}