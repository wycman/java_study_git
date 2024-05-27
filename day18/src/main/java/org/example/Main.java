package org.example;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        test04();
    }

    private static void method1(HashMap<String, String> map) {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }
    }


    /**
     * 统计字符串个数练习
     */
    public static void test01(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : chars) {
            if(!hashMap.containsKey(c))
                hashMap.put(c, 1);
            else{
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }
        //遍历hashmap输出键值对
        hashMap.forEach((key, value) ->{
            System.out.println("字符" + key + "出现次数为" + value + "次!");
        });
    }
    /**
     * 统计省份对应城市的案例练习
     */
    public static void test02() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        //默认输入的省份为4
        for(int i = 0; i < 2; i++){
            System.out.println("请输入省份!");
            String cur_province = scanner.next();
            System.out.println("请输入该省份对应城市个数!");
            int cur_num_city = scanner.nextInt();
            //定义一个临时的hashset存储每一个省份对应的城市集合!
            HashSet<String> hashSet = new HashSet<>();
            for(int j = 0; j < cur_num_city; j++){
                System.out.println("请输入对应城市");
                String cur_city = scanner.next();
                hashSet.add(cur_city);
            }
            hashMap.put(cur_province, hashSet);
        }

        //遍历hashmap得到最终的输出结果!
        hashMap.forEach((key, value) ->{
            System.out.print(key + "=");
            boolean is_first = true;
            for (String city : value) {
                if(!is_first)
                    System.out.print(", ");
                is_first = false;
                System.out.print(city);
            }
            System.out.println();
        });
    }

    /**
     * stream流案例的测试函数
     */
    public static void test03() {
        ArrayList<String> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, "茅森月歌", "逢川慧", "楠芽吹", "乃木园子", "侯国见玉");
        //转为stream流并取出前三个元素并打印输出
        arrayList1.stream().limit(3).forEach(s -> System.out.println(s));
        Stream<String> stream1 = arrayList1.stream().limit(4);
        Stream<String> stream2 = arrayList1.stream().skip(4);
        //合并两个stream流并输出
        Stream<String> concat = Stream.concat(stream2, stream1);
        concat.forEach(s -> System.out.println(s));


    }

    /**
     * stream流综合案例之演员!
     */
    public static void test04() {
        ArrayList<String> men = new ArrayList<>();
        Collections.addAll(men, "lyf", "lu", "wsc", "zhg", "lkj");
        ArrayList<String> women = new ArrayList<>();
        Collections.addAll(women, "lwf", "wsc", "zhg", "lkj", "lghf", "sadfswe");
        //男演员只要名字为三个字的前两个人
        Stream<String> men_stream = men.stream().filter(s -> s.length() == 3).limit(2);
        //女演员只要姓l的，且不要第一个
        Stream<String> women_stream = women.stream().filter(s -> s.startsWith("l")).skip(1);
        Stream<String> concat_stream = Stream.concat(men_stream, women_stream);
        concat_stream.forEach(s -> {
            Actor actor = new Actor(s);
            System.out.println(actor);
        });
    }
}