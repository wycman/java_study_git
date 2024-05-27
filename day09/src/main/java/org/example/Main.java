package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        test_getline_in();


    }
    /**
     * 实现一个简单的test用户登录功能
     */
    public static void test_Login(){
        Scanner scanner = new Scanner(System.in);
        //定义正确的用户名和密码
        String current_username = "wyc";
        String current_password = "123456";
        //功能是键盘获取登录用户名和密码，如果二者皆匹配则退出循环
        //否则，如果输错三次直接提示登录失败，且账号将被锁定
        int count = 3;
        while(true){
            if(count == 0){
                System.out.println("当前剩余登录尝试次数为0, 账号被锁定");
                break;
            }
            System.out.println("请输入您的用户名与密码!");
            System.out.println("提示:当前剩余机会为" + count + "次");
            String username = scanner.next();
            String password = scanner.next();
            if(username.equals(current_username) && password.equals(current_password)){
                System.out.println("登录成功");
                break;
            }else{
                System.out.println("登录失败,请重新尝试");
                count--;
            }
        }
    }

    /**
     * 一个简单的遍历字符串并统计大小写字母、数字字符出现个数的函数
     */
    public static void test_scan_string(){
        //定义统计数字字符、大小写字符在某个字符串中出现次数的变量
        int count_digit = 0, count_upper_case = 0, count_lower_case = 0;
        //输入一个字符串
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                count_digit++;
            else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                count_lower_case++;
            else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                count_upper_case++;
        }
        System.out.println("字符串总长度为:" + str.length() +
                ", 数字字符出现次数为:" + count_digit +
                ", 大写字符出现次数为:" + count_upper_case +
                ", 小写字符出现次数为:" + count_lower_case);
    }

    /**
     * 实现一个简单的字符串拼接案例(将一个int数组中的元素拼接为一个指定格式的的string字符串)
     */
    public static void test_concat_string(int[] array){
        //已知要返回的字符串格式类似为[, , ,]
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++){
            if (i < array.length - 1) {
                stringBuilder.append(array[i]).append(",");
            }else
                stringBuilder.append(array[i]).append("]");
        }

        System.out.println(stringBuilder.toString());
    }

    /**
     * 实现一个简单的字符串反转案例
     */
    public static void string_reverse(){
        //键盘输入一个字符串
        Scanner scanner = new Scanner(System.in);
        String input_str = scanner.next();
        String output_str = "";
        for(int j = input_str.length() - 1; j >= 0; j--){
            output_str += input_str.charAt(j);
        }
        System.out.println("反转后的字符串为:" + output_str);
    }

    /**
     * 实现一个简单的金额转换案例（需求为将一个7位阿拉伯数字转换为中国汉字形式）
     */
    public static void number_transform(){
    //录入一个大于等于0且不超过1000万的整数金额
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        //不满足条件则提示继续录入
        System.out.println("请输入要转换的金额!");
        while(true){
            if(number < 0 || number >= 10000000){
                System.out.println("金额不符合标准格式，请重新录入!");
                number = scanner.nextInt();
                continue;
            }else
                break;
        }
        //定义一个hash数组存储阿拉伯整型数字1-9到汉字的映射关系
        String[] num_map_to_chn = {"零",
                "壹",
                "贰",
                "叁",
                "肆",
                "伍",
                "陆",
                "柒",
                "捌",
                "玖"
        };
        //判断数字的位数，方便在前面补零
        int[] newArray = get_array(number);
        int num_weishu = newArray.length;
        //补成七位数的表示形式
        String step2_res = "";
        for(int i = 0; i < 7 - num_weishu; i++)
        {
            step2_res += "零";
        }
        for (int i = 0; i < num_weishu; i++){
            step2_res += num_map_to_chn[newArray[i]];
        }
        //step2_res现在存储的结果为零零....
        //插入相应的单位
        String ins_charString = "百拾万千百拾元";
        //定义存储最终结果的string
        String final_res = "";
        for (int i = 0; i < ins_charString.length(); i++){
                final_res += step2_res.charAt(i);
                final_res += ins_charString.charAt(i);
        }
        System.out.println("转换的结果为:" + final_res);
    }

    /**
     * 将一个数字中的每一个数字拆分为一个数组并返回
     * @param a
     * @return
     */
    public static int[] get_array(int a){
        int count = 0;
        int residual = a;
        while (residual > 0){
            residual /= 10;
            count++;
        }
        int[] newArray = new int[count];
        for(int i = 0; i < count; i++){
            newArray[count - 1 - i] = a % 10;
            a /= 10;
        }
        return newArray;
    }
    /**
     * 手机号屏蔽test函数
     */
    public static void test_mask_phoneNumber(){
        Scanner scanner = new Scanner(System.in);
        String phone_number = "";
        //输入的手机号必须在11位，否则提示重新输入
        while(true){
        System.out.println("请输入格式合法的11位手机号！");
        phone_number = scanner.next();
        if(phone_number.length() != 11)
        {
            System.out.println("手机号格式不合法，请重新输入！");
            continue;
        }else
            break;
        }
        String mask_phone_number = phone_number.substring(0, 3) + "****"
                + phone_number.substring(7);
        System.out.println("屏蔽后的电话号码为:" + mask_phone_number);
    }

    /**
     * 一个简单的身份证信息打印案例test函数
     */
    public static void test_id_card(){
    //定义一个18位的身份证号码字符串
        String id_number = "420111200102035521";
        //获取身份证号码中代表出生年月日的那一部分
        String date_number = id_number.substring(6, 14);
        //获取身份证号码中代表性别的倒数第二位
        char sex_number = id_number.charAt(id_number.length()-2);
        //输出该身份证号持有者的出生年月日
        print_date_number(date_number);
        //性别对应的数字如果为偶数，代表为女生，否则为男生
        System.out.println("性别为:" + ((sex_number - '0') % 2 == 0 ? "女" : "男"));



    }
    /**
     * 定义一个根据身份证中8位出生日期号码格式化输出真实出生日期的函数
     */
    public static void print_date_number(String date_number){
        String year = date_number.substring(0, 4);
        String month = date_number.substring(4, 6);
        String day = date_number.substring(6);
        //如果月份和天代表的两位数字中第一个为0，则需要在格式输出中去掉
        if(month.charAt(0) == '0')
            month = month.substring(1);
        if(day.charAt(0) == '0')
            day = day.substring(1);
        System.out.println("出生年月日:" + year + "年"
            + month + "月" + day + "日");
    }

    /**
     * 屏蔽敏感词
     */
    public static void test_mask_words(){
        //定义需要进行屏蔽的敏感词库
        String[] arr = {"草你妈","你妈死了","杂种","废物","孤儿",
        "贱种","婊子"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要屏蔽的话!");
        String seq = scanner.next();
        for(int i = 0; i < arr.length; i++){
            seq = seq.replace(arr[i], "***");
        }
        System.out.println("屏蔽后的结果为:"+seq);
    }
    /**
     * 对称字符串判断test函数
     */
    public static void test_sym_string(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder sb = new StringBuilder(str);
        if (sb == sb.reverse())
            System.out.println("是对称字符串");
        else
            System.out.println("不是对称字符串");
    }

    /**
     * 转罗马数字的简单案例test函数
     */
    public static void test_transform_to_roman(){
    //键盘录入一个字符串，要求都为数字且长度小于等于9
        Scanner scanner = new Scanner(System.in);
        String src_str = "";
        while (true){
            System.out.println("请输入一个数字字符串!");
            src_str = scanner.next();
            if (is_valid(src_str))
                break;
            else
                continue;
        }
        StringBuilder src_sb = new StringBuilder(src_str);
        StringJoiner stringJoiner = new StringJoiner(" ","[","]");
        //构建一个将数字字符'0'到'9'转换为罗马字符的hash数组，当然'0'被映射为" "
        String[] hash_map = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        for (int i = 0; i < src_sb.length(); i++){
            stringJoiner.add(hash_map[src_sb.charAt(i) - '0']);
        }
        System.out.println("转化后的结果为:"+stringJoiner.toString());
    }

    /**
     * 转罗马数字案例中使用到的函数，主要判断录入的数字是否符合要求
     */
    public static boolean is_valid(String in_str){
        if (in_str.length() > 9)
        {
            return false;
        }
        for (int i = 0; i < in_str.length(); i++){
            if (!(in_str.charAt(i) >= '0' && in_str.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    /**
     * 字符串旋转案例的简单test函数
     */
    public static void test_stringRotate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个待旋转的字符串A及一个匹配字符串B!");
        String src_str = scanner.next();
        String match_str = scanner.next();
        //如果A经过有限次旋转后可以得到B则返回True
        //如果两个字符串长度不相等，直接返回false
        if(src_str.length() != match_str.length()) {
            System.out.println("匹配失败，两个字符串长度不相等!");
            return;
        }
        //进行旋转，最多只可能旋转A串的长度减一次
        for (int i = 0; i < src_str.length(); i++) {
            StringBuilder new_src_builder = new StringBuilder();
            //进行旋转
            new_src_builder.append(src_str.substring(1, src_str.length()))
                    .append(src_str.charAt(0));
            //给src_str重新赋值
            src_str = new_src_builder.toString();
            if(src_str.equals(match_str)){
                System.out.println("可以!");
                return;
            }
        }
        System.out.println("不行!");
    }


    /**
     * 键盘录入字符串，并随机打乱
     */
    public static void shuffle_string(){
        //设定打乱次数
        int shuffle_count = 6;
        //输入要打乱的字符串
        System.out.println("请输入要打乱的字符串");
        Scanner scanner = new Scanner(System.in);
        String src_str = scanner.next();
        //定义随机种子生成器
        Random random = new Random();
        while (shuffle_count > 0){
            //思路是随机生成一个idx(范围在0-src_str的长度减1之间)
            int idx = random.nextInt(src_str.length());
            //然后每次将idx之前的子串移到末尾
            src_str = src_str.substring(idx) + src_str.substring(0, idx);
            shuffle_count--;
        }
        System.out.println("打乱后的字符串为:" + src_str);

    }

    /**
     * 随机生成五位验证码（四位字母+一位数字）
     */
    public static void test_generate_verify_code(){
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
        System.out.println("生成的随机验证码为:" + final_code_to_string);
    }

    /**
     * 简单的输入数字字符串并计算他们相乘结果的test案例
     */
    public static void test_string_cal(){
        System.out.println("输入两个要相乘的数字字符串!");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int str1_number = transform_numberString_to_int(str1);
        int str2_number = transform_numberString_to_int(str2);
        int final_res = str1_number * str2_number;
        System.out.println("相乘后的结果为:"+transform_int_to_string(final_res));
    }

    /**
     * 将数字形式字符串转换为int整数
     */
    public static int transform_numberString_to_int(String str){
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res;
    }

    /**
     * 将int类型的整数转换为对应的字符串形式
     */
    public static String transform_int_to_string(int number){
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            int current_num = number % 10;
            number /= 10;
            stringBuilder.append(current_num);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    /**
     * 案例6getline输入字符串
     */
    public static void test_getline_in(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入字符串！");
        String input = scanner.nextLine();
        int count = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == ' ')
                break;
            count++;
        }
        System.out.println("最后一个单词的位数为:"+count);

    }
}