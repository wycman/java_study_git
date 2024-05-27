package org.example.q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * **需求**
 *
 * * 红包雨游戏，某企业有100名员工，员工的工号依次是1, 2，3, 4，..到100。现在公司举办了年会活动，活动中有一个红包雨环节，要求共计发出200个红包雨。其中小红包在[1 - 30]  元之间，总占比为80%，大红包[31-100]元，总占比为20%。
 *
 *  **具体的功能点如下**
 *
 * 1、系统模拟上述要求产生200个红包。
 *
 * 2、模拟100个员工抢红包雨，需要输出哪个员工抢到哪个红包的过程，活动结束时需要提示活动结束。
 *
 * 3、活动结束后，请1对100名员工按照所抢红包的总金额进行降序排序展示，**例如：3号员工抢红包总计：293元、1号员工抢红包总计250元，....**
 */
public class Test4 {
    //思路，多线程模拟
    public static void main(String[] args) throws InterruptedException {
        /**
         * 1、系统模拟上述要求产生200个红包。
         */
        Random random = new Random();
        List<Integer> hongbao = new ArrayList<>();
        for(int i = 0; i < 400; i++){
            if(i < 260){
                hongbao.add(random.nextInt(30) + 1);
            }else
                hongbao.add(random.nextInt(70) + 31);
        }
        /**
         * 2、模拟100个员工抢红包雨，需要输出哪个员工抢到哪个红包的过程，活动结束时需要提示活动结束。
         */
        //初始化100个员工
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            employees.add(new Employee(i + "", 0));
        }
        List<Thread> threads = new ArrayList<>();
        for (Employee employee : employees) {
            Thread thread = new Thread(new EmployeeThread(employee, hongbao));
            threads.add(thread);
            thread.start();
            System.out.println(employee.getId() + "开始抢红包");
        }
        for (Thread thread : threads) {
            thread.join();
        }
        employees.stream().sorted((o1, o2) -> o2.getSum_money() - o1.getSum_money()).
                forEach(employee -> System.out.println(employee.getId() + "抢到红包总计：" + employee.getSum_money() + "元"));
    }
}
