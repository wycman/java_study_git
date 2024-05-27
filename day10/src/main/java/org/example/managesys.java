package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class managesys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //创建一个存储用户对象的用户信息列表集
        ArrayList<User> users = new ArrayList<>();
        loop1: while (true) {
            //****用户登录/注册界面
            System.out.println("欢迎登录学生管理系统!");
            System.out.println("请输入操作!");
            System.out.println("1->登录!");
            System.out.println("2->注册!");
            System.out.println("3->忘记密码!");
            System.out.println("其他->直接退出!");
            //用户在登录界面输入自己的选择
            String entry_choose = scanner.next();
            switch (entry_choose){
                case "1"->{
                    boolean login_state = login(users);
                    if(login_state)
                        break loop1;
                    else {
                        System.out.println("重新进行操作!");
                    }
                    break;
                }
                case "2"-> {
                    register(users);
                    break;
                }
                case "3"-> {
                    reset_password(users);
                    break;
                }
                default-> {
                    System.out.println("退出系统!");
                    System.exit(0);
                    break loop1;
                }

            }
        }

        //****学生管理系统界面

        //创建存储学生信息的ArrayList集合
        ArrayList<Student> students = new ArrayList<>();
        loop: while (true) {
            //输出主菜单
            System.out.println("------欢迎来到学生管理系统!------");
            System.out.println("1->添加学生");
            System.out.println("2->删除学生");
            System.out.println("3->修改学生");
            System.out.println("4->查询学生");
            System.out.println("5->退出!");
            System.out.println("请输入您的选择!");
            //用户输入选择
            String choose = scanner.next();
            switch (choose) {
                case "1" ->{
                    add_student(students);
                }
                case "2" ->{
                    del_student(students);
                }
                case "3" ->{
                    update_student(students);
                }
                case "4" ->{
                    query_student(students);
                }
                case "5" ->{
                    System.out.println("退出管理系统!");
                    break loop;
                }
                default ->{}
            }
        }
    }

    /**
     * 编写用户登录函数
     * 返回true表示登录成功
     * 返回false表示登录失败
     */
    public static boolean login(ArrayList<User> users){
        /**
         * 要求如下：
         * 1.判断用户名是否存在，若不存在则提示进行注册
         * 2.生成登录验证码
         * 2.若存在，判断密码与验证码是否均输入正确
         * 3.只有三次输入密码与验证码进行登录的机会，若用完则直接强行退出系统
         */

        Scanner scanner = new Scanner(System.in);
        //功能是键盘获取登录用户名和密码，如果二者皆匹配则退出循环
        //否则，如果输错三次直接提示登录失败，且账号将被锁定
        while(true){
            System.out.println("请输入您的用户名!");
            String current_username = scanner.next();
            //首先获取输入用户名在users集合中的下标
            //如果该下标为-1说明用户名不存在
            int user_ListIdx = get_user_index(users, current_username);
            if(user_ListIdx == -1){
                System.out.println("该用户名不存在，请进行注册后再登录!");
                return false;
            }
            //随机生成登录验证码
            String login_verify_code = generate_verify_code();
            System.out.println("验证码:"+login_verify_code);
            //输入登录密码
            System.out.println("请输入登录验证码!");
            String input_verify_code = scanner.next();
            int count = 3;
            while (true) {
                if(input_verify_code.equals(login_verify_code)){
                    //验证码输入正确，则判断密码是否正确
                    System.out.println("请输入您的密码!");
                    String current_password = scanner.next();
                    if(current_password.equals(users.get(user_ListIdx).getPassword())){
                        System.out.println("登录成功!");
                        break;
                    }
               }
                //说明密码或验证码输入错误
                count--;
                System.out.println("输入的密码或验证码错误!");
                System.out.println("提示:当前剩余机会为" + count + "次");
                //在此处也应加一次判断
                if(count==0){
                    System.out.println("您无法再继续输入了，请滚出这个管理系统吧!");
                    return false;
                }
                System.out.println("请重新输入登录验证码和密码!");
                //随机生成登录验证码
                login_verify_code = generate_verify_code();
                System.out.println("验证码:"+login_verify_code);
                //输入登录密码
                System.out.println("请输入登录验证码!");
                input_verify_code = scanner.next();
            }
        break;
        }
        return true;
    }

    /**
     * 编写用户注册函数
     */
    public static void register(ArrayList<User> users){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要注册的用户名!");
            String current_username = scanner.next();
            //判断该用户名是否已存在
            if(is_username_exist(users, current_username)){
                System.out.println("该用户名已存在，请重新输入!");
                continue;
            }
            //判断用户名输入格式是否合法
            if(!is_username_valid(current_username)){
                System.out.println("输入的用户名格式不合法，请重新输入!");
                continue;
            }
            //输入进行注册的账户密码
            System.out.println("请输入待注册的账号密码!");
            String current_password = scanner.next();
            System.out.println("请再次输入待注册的账号密码!");
            String current_password_verify = scanner.next();
            while (true) {
                //判断两次输入的密码是否一致，若不一致需要重新输入
                if(current_password.equals(current_password_verify))
                    break;
                System.out.println("两次输入的密码不一致，请重新输入!");
                current_password = scanner.next();
                System.out.println("请再次输入待注册的账号密码!");
                current_password_verify = scanner.next();
            }
            //输入进行注册的身份证号码
            System.out.println("请输入进行注册的身份证号码!");
            String current_id = scanner.next();
            while (true){
                //判断输入的身份证号码在格式上是否有效，否则需要重新输入
                if(is_id_valid(current_id))
                    break;
                System.out.println("输入的身份证号无效，请重新输入!");
                current_id = scanner.next();
            }
            //输入进行注册的电话号码
            System.out.println("请输入进行注册的电话号码!");
            String current_telephoneNumber = scanner.next();
            while (true){
                //判断输入的电话号码在格式上是否有效，否则需要重新输入
                if(is_telephoneNumber_valid(current_telephoneNumber))
                    break;
                System.out.println("输入的电话号码格式无效，请重新输入!");
                current_telephoneNumber = scanner.next();
            }
            System.out.println("注册成功!请牢记你的用户名:"+current_username);
            User user = new User(current_username, current_password, current_id, current_telephoneNumber);
            users.add(user);
            break;
        }
    }
    /**
     * 编写用户找回密码函数
     */
    public static void reset_password(ArrayList<User> users){
        /**
         * 要求如下
         * 1. 用户输入用户名，如果用户名不存在则提示需进行注册，并返回主页面
         * 2.用户输入该用户名对应的身份证号码和手机号码，如果输入不正确则提示密码修改失败
         * 3.用户输入新的账号密码，并提示修改成功!
         */
        Scanner scanner = new Scanner(System.in);
        //用户输入用户名
        System.out.println("请输入要找回密码的用户名!");
        String current_username = scanner.next();
        //获取该用户名在users信息列表中的下标
        int user_ListIdx = get_user_index(users, current_username);
        //如果下标为-1表示输入的用户名在原用户信息列表集合中不存在，直接结束
        if(user_ListIdx == -1){
            System.out.println("该用户名不存在，请先进行注册!");
            return;
        }
        //用户输入该用户名对应的身份证号码
        while (true) {
            System.out.println("请输入账户对应的有效身份证号码!");
            String current_id = scanner.next();
            if(!is_id_valid(current_id)){
                //用户输入的身份证号码格式不正确
                System.out.println("输入的身份证号码格式不正确,请重新输入!");
                continue;
            }
            if(!current_id.equals(users.get(user_ListIdx).getId())){
                //用户输入的身份证号码不正确，修改失败，返回菜单!
                System.out.println("输入的身份证号码不正确，修改失败!");
                return;
            }
            break;
        }
        //用户输入该用户名对应的手机号码
        while (true) {
            System.out.println("请输入账户对应的有效手机号码!");
            String current_telephoneNumber = scanner.next();
            if(!is_telephoneNumber_valid(current_telephoneNumber)){
                //用户输入的手机号码格式不正确
                System.out.println("输入的手机号码格式不正确,请重新输入!");
                continue;
            }
            if(!current_telephoneNumber.equals(users.get(user_ListIdx).getTelephoneNumber())){
                //用户输入的手机号码不正确，修改失败，返回菜单!
                System.out.println("输入的手机号码不正确，修改失败!");
                return;
            }
            break;
        }
        //此时该账号的手机号与身份证号码信息均校验正确
        //输入修改后的账号密码
        System.out.println("请输入修改后的账号密码!");
        String current_password = scanner.next();
        users.get(user_ListIdx).setPassword(current_password);
        System.out.println("密码修改成功,请重新登录!");
    }


    /**
     * 编写判断用户名是否在用户信息集合中存在
     * 若存在则返回true，否则返回false
     */
    public static boolean is_username_exist(ArrayList<User> users, String username){

        //遍历users列表集合
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(username))
                return true;
        }

        return false;
    }

    /**
     * 编写判断用户名是否合法的函数
     * 若合法则返回true，否则返回false
     */
    public static boolean is_username_valid(String username){
        /**判断用户名是否合法，需要同时满足两个条件:
         * 1.用户名长度在3-15位之间,
         * 2.用户名只能为字母加数字的组合，且不能全为数字
         */
        //条件1判断
        //如果用户名的长度不满足条件，则直接返回false
        if(username.length() < 3 || username.length() > 15)
            return false;
        //****************************
        //条件2判断
        //判断用户名是否仅为字母加数字的组合
        //同时统计用户名中为字母的字符个数
        int num_alpha = 0;
        for (int i = 0; i < username.length(); i++) {
            if((username.charAt(i) >= '0' && username.charAt(i) <= '9')
            || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z')
            || (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')){
                if((username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')
                || (username.charAt(i) >= 'a' && username.charAt(i) <= 'z')){
                    num_alpha++;
                }
            }else
                //否则的话不满足条件
                return false;
        }
        //判断是否全为数字
        if(num_alpha == 0)
            return false;
        return true;
    }

    /**
     * 判断身份证号码的格式是否有效
     */
    public static boolean is_id_valid(String id){
        /**
         * 身份证号码格式有效需同时满足以下4个条件
         * 1.长度为18位
         * 2.不能以0开头
         * 3.前17位必须都为数字字符
         * 4.最后一位为数字或'X'、'x'
         */

        //条件1判断
        //如果身份证号长度不为18则返回false
        if(id.length() != 18)
            return false;
        //条件2判断
        //如果以0开头，同样直接返回false
        if(id.charAt(0) == '0')
            return false;
        //条件3判断
        for (int i = 0; i < id.length() - 1; i++) {
            //如果前17位存在不为数字的字符，则返回false
            if(!(id.charAt(i) >= '0' && id.charAt(i) <= '9'))
                return false;
        }
        //条件4判断
        char last_id_char = id.charAt(id.length() - 1);
        if(!((last_id_char >= '0' && last_id_char <= '9')
        || last_id_char == 'X' || last_id_char == 'x'
        ))
            return false;
        return true;
    }

    /**
     * 判断传入的电话号码格式是否有效
     */
    public static boolean is_telephoneNumber_valid(String telephoneNumber){
        /**
         * 电话号码的格式有效需同时满足以下4个条件
         * 1.电话号码长度为11位
         * 2.电话号码不能以0为开头
         * 3.电话号码必须全为数字
         */
        //条件1判断
        //如果电话号码长度不为11则返回false
        if(telephoneNumber.length() != 11)
            return false;
        //条件2判断
        //如果电话号码以0开头，同样直接返回false
        if(telephoneNumber.charAt(0) == '0')
            return false;
        //条件3判断
        for (int i = 0; i < telephoneNumber.length(); i++) {
            //如果电话号码存在不为数字的字符，则返回false
            if(!(telephoneNumber.charAt(i) >= '0' && telephoneNumber.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    /**
     * 随机生成五位验证码函数（四位字母+一位数字）
     */
    public static String generate_verify_code(){
        //定义存储26个英文大小写字母的字符数组
        // 定义存储26个大写字母的StringBuilder对象
        Random random = new Random();
        StringBuilder Alphabet_builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            Alphabet_builder.append((char) ('A' + i)).append((char) ('a' + i));
        }
        //定义接收验证码四个字母形式的StringBuilder容器
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < 4; i++){
            int idx = random.nextInt(52);
            code.append(Alphabet_builder.charAt(idx));
        }
        String code_to_string = code.toString();
        //随机生成数字字符插入的idx
        int ins_idx = random.nextInt(5);
        //随机生成一个数字
        int random_number = random.nextInt(10);
        //定义接受最终验证码形式的StringBuilder
        StringBuilder final_code = new StringBuilder();
        final_code.append(code_to_string.substring(0, ins_idx))
                .append(random_number).append(code_to_string.substring(ins_idx));
        String final_code_to_string = final_code.toString();
        return final_code_to_string;
    }

    /**
     * 根据用户名返回对应的用户账号在users列表中的下标，方便后续操作
     * 若传入的用户名在users集合中的不存在，则返回-1
     */
    public static int get_user_index(ArrayList<User> users, String username){
        //遍历users集合，找到username对应的下标
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(username))
                return i;
        }
        return -1;
    }

    /**
     * **************************分界线*****************************
     */

    /**
     * 编写学生管理系统对应的添加学生功能函数!
     */
    public static void add_student(ArrayList<Student> students){
    //添加学生信息，且保证list中存储的所有学生其id均唯一
    //故而如果输入的学生信息对应id与list中已经存储的学生信息对应的id有重复的则提示添加失败，请重新输入学生信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请按顺序输入要添加的学生信息:" +
                "ID、姓名、年龄和家庭住址");
        while (true){
            String current_id = scanner.next();
            String current_name = scanner.next();
            int current_age = scanner.nextInt();
            String current_address = scanner.next();
            //如果输入的学生id在原学生信息集合中已经存在，则进行提示并重新输入学生信息!
            if(verify_input_id_exist(students, current_id)){
                System.out.println("当前学生的id已经存在，请重新输入!");
                continue;
            }
            Student temp = new Student(current_id, current_name,
                    current_age, current_address);
            students.add(temp);
            System.out.println("添加成功!");
            break;
        }
    }
    /**
     * 编写学生管理系统对应的删除学生功能函数！
     */
    public static void del_student(ArrayList<Student> students){
        //根据输入的学生id删除对应学生!
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的学生id!");
            String current_id = scanner.next();
            int ListIdx = get_ListIdx_by_id(students, current_id);
            //查询待删除的id所对应学生对象在原学生信息集合中的下标，并进行相关操作
            if(ListIdx != -1)
            {
                System.out.println("删除成功!");
                students.remove(ListIdx);
            }else
                System.out.println("当前id在原学生信息集合中不存在!");

    }
    /**
     * 编写学生管理系统对应的修改学生功能函数!
     */
    public static void update_student(ArrayList<Student> students){
        Scanner scanner = new Scanner(System.in);
            //键盘录入学生id,如果id存在则可以继续输入学生的其他信息
            //如果不存在，则提示待修改的学生不存在，需要重新输入id
        System.out.println("请输入要修改的学生id!");
        String current_id = scanner.next();
            //获取当前待修改的学生在原学生信息列表中的下标!
            int ListIdx = get_ListIdx_by_id(students, current_id);
            if(ListIdx == -1) {
                System.out.println("当前学生id不存在!");
                return;
            }
            //存在的话则可以继续输入待修改的学生信息！
            System.out.println("请输入修改后的学生姓名!");
            String current_name = scanner.next();
            System.out.println("请输入修改后的学生年龄!");
            int current_age = scanner.nextInt();
            System.out.println("请输入修改后的学生家庭住址！");
            String current_address = scanner.next();
            Student temp = new Student(current_id, current_name,
                    current_age, current_address);
            //更新原学生列表中下标为ListIdx的对应学生
            students.set(ListIdx, temp);
            System.out.println("学生信息更新成功!");
    }
    /**
     * 编写学生管理系统对应的查询学生功能函数!
     */
    public static void query_student(ArrayList<Student> students){
        //查询并打印所有学生的信息，如果无学生信息则提示添加学生
        if(students.size() == 0){
            System.out.println("当前系统内没有任何的学生信息，请添加后再查询!");
        }else{
            System.out.println("id:\t\t"+"姓名\t\t"
            +"年龄\t\t"+"家庭住址\t\t");
            //遍历传入的学生列表并进行输出
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).getId() + "\t\t"
                + students.get(i).getName() + "\t\t"
                + students.get(i).getAge() +"\t\t"
                + students.get(i).getAddress());
            }
        }
    }

    /**
     * 定义判断存储所有学生信息的ArrayList中是否有学生的id与当前传入的待验证id相同
     * 若是，则返回true（表示当前输入的学生id已经在原学生集合中存在）
     * 否则，返回false（表示当前输入的学生id不在原学生信息集合中
     */
    public static boolean verify_input_id_exist(ArrayList<Student> students, String id){
        //遍历列表集合中存储的所有学生信息
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id))
                return true;
        }
        return false;
    }

    /**
     * 根据学生id查询该学生在学生信息列表中的下标并返回!
     * 如果该学生id不存在，则返回-1
     */
    public static int get_ListIdx_by_id(ArrayList<Student> students, String id){
        //遍历students列表并进行检索
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id)){
                //找到了
                return i;
            }
        }
        //该id在原学生信息列表中不存在，返回-1
        return -1;
    }
}
