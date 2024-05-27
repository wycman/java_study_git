package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        test_get_multi_objects();
    }


    /**
     * 简单的ArrayList集合遍历test函数
     */
    public static void test_scan_array_list(){
        //定义一个存储数据类型为Integer类型的ArrayList
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        //遍历集合
        System.out.print("[");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if(i < arrayList.size() - 1)
                System.out.print(", ");

        }
        System.out.println("]");
    }

    /**
     * ArrayList添加自定义数据类型
     */
//    public static void test_array_list_add_object(){
//    //定义一个存储自定义数据类型Student的arraylist
//        ArrayList<Student> students = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要添加学生对象的个数!");
//        int num_students = scanner.nextInt();
//        for (int i = 0; i < num_students; i++) {
//            System.out.println("请输入要添加的学生信息：姓名及年龄!");
//            String current_name = scanner.next();
//            int current_age = scanner.nextInt();
//            students.add(new Student(current_name, current_age, 0, 0));
//        }
//        //遍历students集合
//        for (int i = 0; i < students.size(); i++) {
//            System.out.println(students.get(i).toString());
//        }
//
//    }

    /**
     * 一个简单的根据用户id查询该用户在ArrayList中是否存在的test函数案例
     */
//    public static void test_find_user_by_id(){
//        //定义一个ArrayList，其中存储的基本数据类型为User对象
//        ArrayList<User> users = new ArrayList<>();
//
//        //初始化users列表，添加几个用户对象
//        users.add(new User("0001", "wyc", "123456"));
//        users.add(new User("0002", "wwc", "123456"));
//        users.add(new User("0003", "wwy", "123456"));
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入要查找的用户id!");
//        String user_id = scanner.next();
//        //遍历users列表集合
//        for (int i = 0; i < users.size(); i++) {
//            if(users.get(i).getUser_id().equals(user_id)){
//                System.out.println("成功查找到该用户!该用户信息如下:");
//                System.out.println(users.get(i).toString());
//                return;
//            }
//        }
//        System.out.println("查询失败,目标用户集合中不存在该id的用户!");
//    }

    /**
     * 定义一个简单的返回多个对象的test函数案例
     */
    public static void test_get_multi_objects() {
    //定义一个ArrayList存储Phone对象
        ArrayList<Phone> phones = new ArrayList<>();
    //添加四部手机
        phones.add(new Phone("小米", 2400));
        phones.add(new Phone("huawei", 5400));
        phones.add(new Phone("apple", 8400));
        phones.add(new Phone("qcyte", 2700));
        System.out.println("预定义集合中价格低于3000的手机信息如下所示:");
    //返回phones中定义的所有对象中价格低于3000的手机集合
        ArrayList<Phone> new_phones = get_price_less_than(phones, 300);
        for (int i = 0; i < new_phones.size(); i++) {
            System.out.println(new_phones.get(i).toString());
        }
    }

    /**
     * 定义一个简单的返回arraylist集合phones中手机价格低于传入price的多个对象函数
     * 最好以相同的ArrayList格式返回
     */
    public static ArrayList<Phone> get_price_less_than(ArrayList<Phone> arrayList, int price){
        //定义一个新的ArrayList用以存储筛选得到的对象集合
        ArrayList<Phone> new_phones = new ArrayList<>();
        //遍历旧的集合进行筛选并添加到新的返回集合中去
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getPrice() <= 3000) {
                Phone temp = arrayList.get(i);
                new_phones.add(arrayList.get(i));
            }
        }
    return new_phones;
    }
}