package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       test_students_manage();
    }

    /**
     * 构建格斗游戏的测试函数
     */
    public static void test_fight() {
        /**
         * 定义两位玩家
         */
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请选择先手！输入1表示玩家1先手, 2表示玩家2先手");
            int status = scanner.nextInt();
            Role role1 = new Role("player1", "女", 100);
            Role role2 = new Role("player2", "男", 100);
            if (status == 1) {
                role2.setHp(role2.getHp() + 15);
                while (role1.getHp() > 0 && role2.getHp() > 0) {
                    role1.attack(role2);
                    if (role2.getHp() == 0) {
                        System.out.printf("长相%s的%s获胜了!", role1.getFace(),
                                role1.getName());
                        System.out.println();
                        break;
                    }
                    role2.attack(role1);
                    if (role1.getHp() == 0) {
                        System.out.printf("长相%s的%s获胜了！", role2.getFace(),
                                role2.getName());
                        System.out.println();
                        break;
                    }
                }
            } else {
                role1.setHp(role1.getHp() + 15);
                while (role1.getHp() > 0 && role2.getHp() > 0) {
                    role2.attack(role1);
                    if (role1.getHp() == 0) {
                        System.out.printf("长相%s的%s获胜了!", role2.getFace(),
                                role2.getName());
                        System.out.println();
                        break;
                    }
                    role1.attack(role2);
                    if (role2.getHp() == 0) {
                        System.out.printf("长相%s的%s获胜了!", role1.getFace(),
                                role1.getName());
                        System.out.println();
                        break;
                    }
                }
            }
            System.out.println("是否重新开始游戏，1代表是!");
            int is_reboot = scanner.nextInt();
            if(is_reboot == 0){
                break;
            }
        }
    }

    /**
     * 定义数组存储商品对象的test函数实现
     *
     */
    public static void test_array_store_products() {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[3];
        for(int i=0; i<products.length; i++) {
        System.out.println("请输入商品的信息，分别是：商品名字、价格与库存!");
        //录入字符串
        String product_name = scanner.next();
        String product_id = "" + i;
        int product_price = scanner.nextInt();
        int product_storage = scanner.nextInt();
        products[i] = new Product(product_id, product_name,
                product_price, product_storage);
        }
        //遍历对象数组并输出信息
        for(int i = 0; i < products.length; i++){
            System.out.println("商品id:" + products[i].getId() +
                    ", 商品名:" + products[i].getName() +
                    ", 商品价格:" + products[i].getPrice() +
                    ", 商品库存:" + products[i].getStorage());
        }
    }

    /**
     * 定义一个test函数，目的是将三个手机对象存入一个数组中，
     * 并计算它们的平均价格并打印输出
     */
    public static void test_calculate_phone_average_price(){
        Scanner scanner = new Scanner(System.in);
        Phone[] Phones = new Phone[3];
        double average_price = 0.0, sum_price = 0.0;
        for(int i=0; i < Phones.length; i++) {
            System.out.println("请输入手机的信息，分别是：手机品牌、手机价格与手机颜色!");
            //录入字符串
            String phone_brand = scanner.next();
            int phone_price = scanner.nextInt();
            String phone_color = scanner.next();
            Phones[i] = new Phone(phone_brand, phone_price,
                    phone_color);
            sum_price += phone_price;
        }
        average_price = sum_price / Phones.length;
        //遍历对象数组并输出信息
        for(int i = 0; i < Phones.length; i++){
            System.out.println("手机品牌:" + Phones[i].getBrand() +
                    ", 手机价格:" + Phones[i].getPrice() +
                    ", 手机颜色:" + Phones[i].getColor());
        }
        System.out.println("*************");
        System.out.println("所有手机对象的平均价格为:" + average_price);
    }

    /**
     * 定义女朋友对象数组以及相关操作的案例test函数
     */
    public static void test_girlfriends_example(){
        Scanner scanner = new Scanner(System.in);
        GirlFriend[] girlFriends = new GirlFriend[4];
        double sum_age = 0.0, average_age = 0.0;
        int count_age_less_than_avg = 0;
        //首先录入女朋友信息并将其添加到数组中去, 同时累加计算所有女朋友对象年龄总和
        for(int i = 0; i < girlFriends.length; i++){
            System.out.println("请输入女朋友" + (i+1) +
                    "的信息，分别是：姓名、年龄、性别与爱好!");
            //录入字符串
            String gf_name = scanner.next();
            int gf_age = scanner.nextInt();
            String gf_gender = scanner.next();
            String gf_hobby = scanner.next();
            girlFriends[i] = new GirlFriend(gf_name, gf_age,
                    gf_gender, gf_hobby);
            sum_age += gf_age;
        }
        average_age = sum_age / girlFriends.length;
        //统计所有女友对象中年龄低于平均年龄的对象个数
        for(int i = 0; i < girlFriends.length; i++){
            if(girlFriends[i].getAge() < average_age)
                count_age_less_than_avg++;
        }
        System.out.println("所有女朋友的平均年龄为:" + average_age +
                ", 低于平均年龄的女友对象个数为: " + count_age_less_than_avg);
        System.out.println("他们的信息如下:");
        for(int i = 0; i < girlFriends.length; i++){
            if(girlFriends[i].getAge() < average_age) {
                System.out.println("女朋友" + (i + 1) + ":");
                System.out.println("姓名:" + girlFriends[i].getName()
                        + ", 年龄:" + girlFriends[i].getAge() + ", 性别:" +
                        girlFriends[i].getGender() + ", 爱好:" +
                        girlFriends[i].getHobby());
            }
        }
    }

    /**
     * 一个简单的学生管理案例
     */
    public static void test_students_manage(){
        Scanner scanner = new Scanner(System.in);
        //定义存储学生对象的数组
        Student[] students = new Student[3];
        //随便创建几个学生对象存进去
        students[0] = new Student("0335", "wyc", 24);
        students[1] = new Student("0336", "zmr", 23);
        students[2] = new Student("0337", "zmc", 25);

        while (true) {
            System.out.println("请输入要添加学生的信息，包括学号、姓名以及年龄");
            String id = scanner.next();
            String name = scanner.next();
            int age = scanner.nextInt();
            Student s = new Student(id, name, age);
            //首先判断该学生对象的学号是否唯一，如果不唯一则无法插入
            if(if_contains_id(s, students)){
                //还需看对象数组中的有效元素个数是否等于数组最大长度
                //如果数组已满，则应开辟新数组并进行赋值及拷贝
                //获取对象数组中的有效元素个数
                int array_size = current_count_students(students);
                if(array_size == students.length){
                    Student[] new_students = new Student[students.length + 1];
                    copy_array(students, new_students);
                    new_students[students.length] = s;
                    print_students_array(new_students);
                }else{
                    //数组未存满，则直接添加
                    students[current_count_students(students)] = s;
                    print_students_array(students);
                }
                break;
            }
            System.out.println("学号不唯一，请重新输入学生信息!");
        }
        //删除案例
        System.out.println("删除案例!");
        //请输入要删除学生对象对应的id
        System.out.println("请输入要删除学生的id");
        String id_to_del = scanner.next();
        //获取待删除学生在数组中对应的下标
        int array_idx = find_idx_by_id(id_to_del, students);
        if(array_idx == -1){
            System.out.println("删除失败，数组中没有该学号的学生!");
        }else{
            System.out.println("删除成功!");
            del_by_index(array_idx, students);
            print_students_array(students);
        }
    }
    /**
     * 判断当前学生对象数组中存了多少个元素
     */
    public static int current_count_students(Student[] students){
        int size = 0;
        for(int i = 0; i < students.length; i++){
            if(students[i] != null)
                size++;
            else
                break;
        }
        return size;
    }

    /**
     * 判断传入的学生对象所对应的学号在整个学生对象数组中是否唯一
     */
    public static boolean if_contains_id(Student s, Student[] students){
        boolean only_flag = true;
        for(int i = 0; i < students.length; i++) {
            if (students[i] == null)
                break;
            //如果在学生对象数组中找到了拥有一样学号的对象则将相应的标识符only_flag设置为false
            if(s.getId().equals(students[i].getId())){
                only_flag = false;
                break;
            }
        }
        return only_flag;
    }


    /**
     * 数组拷贝
     */
    public static void copy_array(Student[] src, Student[] tar){
        for(int i = 0; i < src.length; i++){
            tar[i] = src[i];
        }
    }

    /**
     * 打印学生数组
     */
    public static void print_students_array(Student[] students){
        for(int i = 0; i < students.length && students[i] != null; i++){
            System.out.println(students[i].toString());
        }
    }

    /**
     * 通过传入的学生对象学号找到该对象在数组中的下标
     */
    public static int find_idx_by_id(String id, Student[] students){
        for(int i = 0; i < students.length && students[i] != null; i++){
            if(students[i].getId().equals(id)){
                return i;
            }
        }
        //未找到则返回-1
        return -1;
    }

    /**
     * 根据数组下标删除对应元素
     *
     */
    public static void del_by_index(int idx, Student[] students){
        int i = 0;
        for(i = idx; i < students.length - 1 && students[i] != null; i++){
            students[i] = students[i+1];
        }
        students[i] = null;
    }
}