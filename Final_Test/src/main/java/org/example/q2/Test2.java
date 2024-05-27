package org.example.q2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 题目要求如下：
 * 某个班级组织团建活动，班长给出了几个去处给大家选择，分别是 “农家乐” , "轰趴"，“野外拓展”，“健身房”，本次活动每个学生是可以多选的。
 *
 * * 现在有如下5名学生选择了如下去处。
 *
 * ```
 * 张全蛋儿  农家乐,野外拓展
 * 李二狗子  轰趴,野外拓展,健身房
 * 翠花     野外拓展，
 * 小帅     轰趴，健身房
 * 有容     农家乐
 * ```
 *
 * **具体的功能点如下：**
 *
 * 1、请找出每个去处想去的人数是多少，并输出投票最多的去处是哪个。
 *
 * 2、请找出哪些人没有选择投票最多的去处，输出他们的名字。（**本案例用不用stream流做都给分**）
 *
 * ​		**比如：小帅，有容没有选择野外拓展。**
 */
public class Test2 {
    public static void main(String[] args) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        //添加信息
        hashMap.put("乃木园子", new ArrayList<String>());
        hashMap.get("乃木园子").add("农家乐");
        hashMap.get("乃木园子").add("野外拓展");
        hashMap.put("卡缪", new ArrayList<String>());
        hashMap.get("卡缪").add("轰趴");
        hashMap.get("卡缪").add("野外拓展");
        hashMap.get("卡缪").add("健身房");
        hashMap.put("阿姆罗", new ArrayList<String>());
        hashMap.get("阿姆罗").add("野外拓展");
        hashMap.put("巴纳吉", new ArrayList<String>());
        hashMap.get("巴纳吉").add("轰趴");
        hashMap.get("巴纳吉").add("健身房");
        hashMap.put("希罗", new ArrayList<String>());
        hashMap.get("希罗").add("农家乐");

        //1、请找出每个去处想去的人数是多少，并输出投票最多的去处是哪个
        System.out.println("******");
        //treemap存储每个去处想去的人数
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (List<String> value : hashMap.values()) {
            for (String s : value) {
                if (treeMap.containsKey(s)){
                    treeMap.put(s, treeMap.get(s) + 1);
                }else{
                    treeMap.put(s, 1);
                }
            }
        }
        treeMap.forEach((k, v) -> System.out.println(k + "想去人数为:" + v));

        //找出投票最多的去处
        System.out.println("******");
        Map.Entry<String, Integer> max_votes_entry = treeMap.entrySet().stream().max(
                (o1, o2) -> o1.getValue() - o2.getValue()
        ).get();
        System.out.println("投票最多的去处是:");
        Stream<Map.Entry<String, Integer>> max_votes_Stream = treeMap.entrySet().stream().filter(entry -> entry.getValue() == max_votes_entry.getValue());
        Map<String, Integer> max_votes_map = max_votes_Stream.collect(Collectors.toMap(
                entry -> entry.getKey()
                ,
                entry -> entry.getValue()
        ));
        max_votes_map.forEach((k, v) -> System.out.println(k + "最多人去，人数为:" + v));
    // 2、请找出哪些人没有选择投票最多的去处，输出他们的名字。
        System.out.println("*******");
        hashMap.keySet().stream().filter(
            s -> {
                for (String string : max_votes_map.keySet()) {
                    if (hashMap.get(s).contains(string))
                        return false;
                }
                return true;
            }
        ).forEach(s -> System.out.println(s + "没有选择投票最多的去处"));
    }
}
